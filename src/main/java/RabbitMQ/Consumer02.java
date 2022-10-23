package RabbitMQ;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer02 {
    public static final String QUEUE_NAME = "WF queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("消费者02获取到消息:"+msg);

                //手动确认收到了消息:
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };


        //设置消费者 每次获取几条消息
//        channel.basicQos(2);

        //监听队列
        // true代表自动签收 false代表手动签收-消费者消费成功后-才通知队列删除
        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);


    }
}
