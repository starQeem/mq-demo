package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Date: 2023/4/14 22:24
 * @author: Qeem
 */
@Component
public class SpringRabbitListener {
    //    @RabbitListener(queues = "simple.queue")
//    public void listenSimpleQueueMessage(String msg) throws InterruptedException{
//        System.out.println("spring 消费者收到消息: ["+msg+"]");
//    }
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage1(String msg) throws InterruptedException {
        System.out.println("spring 消费者收到消息1: [" + msg + "]"+ LocalDateTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage2(String msg) throws InterruptedException{
        System.err.println("spring 消费者收到消息2........: ["+msg+"]"+LocalDateTime.now());
        Thread.sleep(200);
    }

    //Fanout消息接收
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMessage1(String msg){
        System.out.println("spring 消费者收到消息1: [" + msg + "]"+ LocalDateTime.now());
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMessage2(String msg){
        System.err.println("spring 消费者收到消息2........: ["+msg+"]"+LocalDateTime.now());
    }

}
