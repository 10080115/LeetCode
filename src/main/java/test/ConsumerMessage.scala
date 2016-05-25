import org.apache.spark.streaming._
import org.apache.spark._
import org.apache.spark.streaming.kafka.KafkaUtils

object  ConsumerMessage{
    def main(args:Array[String]): Unit ={
      val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount").set("spark.ui.port", "44040" )
      val sc = new StreamingContext(conf,Seconds(2))
      val kafkaStream = KafkaUtils.createStream(sc, "localhost:2181","spark-streaming-consumer-group", Map("spark-topic" -> 5))
      kafkaStream.print()
      sc.start()
      sc.awaitTermination()
    }
}