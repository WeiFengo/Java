package RabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Producer {

    public static final String QUEUE_NAME = "WF queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        //创建通道
        Channel channel = connection.createChannel();


        //投放消息

        for (int i = 1; i <= 6; i++) {
            String msg = "微风";
            msg = msg + i;
            channel.basicPublish("",QUEUE_NAME, null,msg.getBytes());

        }


        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
