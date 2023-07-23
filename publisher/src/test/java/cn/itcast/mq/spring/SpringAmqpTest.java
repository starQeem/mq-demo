package cn.itcast.mq.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Date: 2023/4/14 21:43
 * @author: Qeem
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        //队列名称
        String queueName = "simple.queue";
        //消息
        String message = "hello,Spring ampq!";
        //发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testWorkQueue() throws InterruptedException {
        //队列名称
        String queueName = "simple.queue";
        //消息
        String message = "hello,Spring ampq!";
        //发送消息
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message);
            Thread.sleep(20);
        }
    }
    @Test
    public void testFanoutExchange() {
        //队列名称
        String exchangeName = "starQeem.fanout";
        //消息
        String message = "hello,everyOne";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testSendDirectExchange() {
        //交换机名称
        String exchangeName = "starQeem.direct";
        //消息
        String message = "黄色警报,嘎嘎嘎嘎!";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"yellow",message);
    }

    @Test
    public void testSendTopicExchange() {
        //交换机名称
        String exchangeName = "starQeem.topic";
        //消息
        String message = "诶嘿诶嘿";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName, "japan.news", message);
    }
}
