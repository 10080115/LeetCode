import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

object  wordCounts{
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)
    val input = sc.textFile("readme")
    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word,1)).reduceByKey{case (x,y) => x+y}
    counts.saveAsTextFile("outfiles")
  }
}