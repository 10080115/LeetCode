import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object  wordCounts2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val M = new RowMatrix(sc.textFile("readme").map(_.split(' '))
      .map(_.map(_.toDouble)).map(_.toArray)
      .map(line => Vectors.dense(line)))
    val svd = M.computeSVD(2, true)

    val U = svd.U
    //U..foreach(println)
    val S = svd.s
    print(S)
    println()
    val V = svd.V
    print(V)
  }
}