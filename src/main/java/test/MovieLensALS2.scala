package test

import org.apache.log4j.{Level, Logger}

import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}

import org.apache.spark.rdd._

import org.apache.spark.{SparkContext, SparkConf}

import org.apache.spark.SparkContext._

import scala.io.Source

/**
  * Created by lishiwei on 16/4/26.
  */
object MovieLensALS2 {

  def main(args: Array[String]) {
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    Logger.getLogger("org.apache.eclipse.jetty.server").setLevel(Level.OFF)



    //设置运行环境

    val sparkConf = new SparkConf().setAppName("MovieLensALS").setMaster("local")

    val sc = new SparkContext(sparkConf)



    //装载用户评分，该评分由评分器生成(即生成文件personalRatings.txt)

    //val myRatings = loadRatings(args(1))
    val myRatings = loadRatings("/Users/lishiwei/Downloads/dataSet/ml-1m/ratings.dat")

    //Rating(5749,2726,5.0)
    val myRatingsRDD = sc.parallelize(myRatings, 1)

    //样本数据目录

    val movielensHomeDir = "/Users/lishiwei/Downloads/dataSet/ml-1m"



    //装载样本评分数据，其中最后一列Timestamp取除10的余数作为key，Rating为值，即(Int，Rating)
    //(7,Rating(5788,2195,2.0))
    val ratings = sc.textFile(movielensHomeDir + "/ratings.dat").map {

      line =>

        val fields = line.split("::")

        // format: (timestamp % 10, Rating(userId, movieId, rating))

        (fields(3).toLong % 10, Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble))

    }

    //抽取电影的信息
    //2163 -> Attack of the Killer Tomatoes! (1980)
    val movies = sc.textFile(movielensHomeDir + "/movies.dat").map {

      line =>

        val fields = line.split("::")

        // format: (movieId, movieName)

        (fields(0).toInt, fields(1))

    }.collect().toMap

    //Got 1000209 ratings from 6040 users 3706 movies
    val numRatings = ratings.count()

    val numUsers = ratings.map(_._2.user).distinct().count()

    val numMovies = ratings.map(_._2.product).distinct().count()

    //将数据按照第时间的第一个分片来作为训练集 训练 校验 测试各20%的数据
    val numPartitions = 4

    val training = ratings.filter(x => x._1 < 6).values.union(myRatingsRDD).repartition(numPartitions).persist()

    val validation = ratings.filter(x => x._1 >= 6 && x._1 < 8).values.repartition(numPartitions).persist()

    val test = ratings.filter(x => x._1 >= 8).values.persist()


    val numTraining = training.count()

    val numValidation = validation.count()

    val numTest = test.count()

    //训练不同参数下的模型，并在校验集中验证，获取最佳参数下的模型

    val ranks = List(8, 12)

    val lambdas = List(0.1, 10.0)

    val numIters = List(10, 20)

    var bestModel: Option[MatrixFactorizationModel] = None

    var bestValidationRmse = Double.MaxValue

    var bestRank = 0

    var bestLambda = -1.0

    var bestNumIter = -1



    for (rank <- ranks; lambda <- lambdas; numIter <- numIters) {

      val model = ALS.train(training, rank, numIter, lambda)

      val validationRmse = computeRmse(model, validation, numValidation)

      println("RMSE(validation) = " + validationRmse + " for the model trained with rank = "

        + rank + ",lambda = " + lambda + ",and numIter = " + numIter + ".")


      if (validationRmse < bestValidationRmse) {

        bestModel = Some(model)

        bestValidationRmse = validationRmse

        bestRank = rank

        bestLambda = lambda

        bestNumIter = numIter

      }

    }



    //用最佳模型预测测试集的评分，并计算和实际评分之间的均方根误差（RMSE）

    val testRmse = computeRmse(bestModel.get, test, numTest)

    println("The best model was trained with rank = " + bestRank + " and lambda = " + bestLambda

      + ", and numIter = " + bestNumIter + ", and its RMSE on the test set is " + testRmse + ".")



    //create RemoveLinkedListElements naive baseline and compare it with the best model

    val meanRating = training.union(validation).map(_.rating).mean

    val baselineRmse = math.sqrt(test.map(x => (meanRating - x.rating) * (meanRating - x.rating)).reduce(_ + _) / numTest)

    val improvement = (baselineRmse - testRmse) / baselineRmse * 100

    println("The best model improves the baseline by " + "%1.2f".format(improvement) + "%.")



    //推荐前十部最感兴趣的电影，注意要剔除用户已经评分的电影

    val myRatedMovieIds = myRatings.map(_.product).toSet

    val candidates = sc.parallelize(movies.keys.filter(!myRatedMovieIds.contains(_)).toSeq)

    val recommendations = bestModel.get

      .predict(candidates.map((0, _)))

      .collect

      .sortBy(-_.rating)

      .take(10)

    var i = 1

    println("Movies recommended for you:")

    recommendations.foreach { r =>

      println("%2d".format(i) + ": " + movies(r.product))

      i += 1

    }



    sc.stop()

  }

  /** 校验集预测数据和实际数据之间的均方根误差 **/

  def computeRmse(model:MatrixFactorizationModel,data:RDD[Rating],n:Long):Double = {

    val predictions:RDD[Rating] = model.predict((data.map(x => (x.user,x.product))))

    val predictionsAndRatings = predictions.map{ x =>((x.user,x.product),x.rating)}

      .join(data.map(x => ((x.user,x.product),x.rating))).values

    math.sqrt(predictionsAndRatings.map( x => (x._1 - x._2) * (x._1 - x._2)).reduce(_+_)/n)

  }


  def loadRatings(path:String):Seq[Rating] = {

    val lines = Source.fromFile(path).getLines()

    val ratings = lines.map{

      line =>

        val fields = line.split("::")

        Rating(fields(0).toInt,fields(1).toInt,fields(2).toDouble)

    }.filter(_.rating > 0.0)

    if(ratings.isEmpty){

      sys.error("No ratings provided.")

    }else{

      ratings.toSeq

    }

  }
}