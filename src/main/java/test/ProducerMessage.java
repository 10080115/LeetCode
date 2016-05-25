package test;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class ProducerMessage {
    private final Producer<String,String> producer;
    public final static String TOPIC = "spark-topic";

    private ProducerMessage(){
        Properties props = new Properties();
        //此处配置的是kafka的端口
        props.put("metadata.broker.list", "localhost:9092");

        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        //request.required.acks
        //0, which means that the producer never waits for an acknowledgement from the broker (the same behavior as 0.7). This option provides the lowest latency but the weakest durability guarantees (some data will be lost when RemoveLinkedListElements server fails).
        //1, which means that the producer gets an acknowledgement after the leader replica has received the data. This option provides better durability as the client waits until the server acknowledges the request as successful (only messages that were written to the now-dead leader but not yet replicated will be lost).
        //-1, which means that the producer gets an acknowledgement after all in-sync replicas have received the data. This option provides the best durability, we guarantee that no messages will be lost as long as at least one in sync replica remains.
        props.put("request.required.acks","-1");

        producer = new Producer<String,String>(new ProducerConfig(props));
    }

    //写一个读文件的东西
    void produce() {
        //timeuser.dic代表的是用户的数目
        //timeseq代表的是用户
        int messageNo =  10;
        final int COUNT = 1000000;

        while (messageNo < COUNT) {
            //
            String key = String.valueOf(messageNo);
            String data = "hello kafka message " + key;
            producer.send(new KeyedMessage<String, String>(TOPIC,key,data));
            messageNo ++;
            System.out.println(data);
        }
    }

    public static void main( String[] args ) {
        new ProducerMessage().produce();
    }
}