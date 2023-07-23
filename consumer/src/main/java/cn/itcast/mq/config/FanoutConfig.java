package cn.itcast.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.Queue;

/**
 * @Date: 2023/4/15 16:46
 * @author: Qeem
 */
@Configuration
public class FanoutConfig {
    /*
    * 声明交换机
    * Fanout类型交换机
    * */
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange("starQeem.fanout");
//    }
//    /*
//    * 第一个队列
//    * */
//    @Bean
//    public Queue fanoutQueue1(){
//        return new Queue("fanout.queue1");
//    }
//    /*
//    * 绑定队列1和交换机
//    * */
//    @Bean
//    public Binding bindingQueue1(Queue fanoutQueue1,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
//    }
//    /*
//    * 第二个队列
//    * */
//    @Bean
//    public Queue fanoutQueue2(){
//        return new Queue("fanout.queue2");
//    }
//    /*
//    * 绑定队列2到交换机
//    * */
//    @Bean
//    public Binding bindingQueue2(Queue fanoutQueue2,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
//    }

    /*
    * 基于注解声明队列和交换机
    * */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "starQeem.direct",type = ExchangeTypes.DIRECT),
            key = {"red","blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者接收到direct.queue1的消息 : [" + msg + "]");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "starQeem.direct",type = ExchangeTypes.DIRECT),
            key = {"red","yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("消费者接收到direct.queue2的消息 : [" + msg + "]");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "starQeem.topic",type = ExchangeTypes.TOPIC),
            key = "china.#"  //只要是中国的消息都接收
    ))
    public void listenTopicQueue1(String msg){
        System.out.println("消费者接收到direct.queue1的消息 : [" + msg + "]");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "starQeem.topic",type = ExchangeTypes.TOPIC),
            key = "#.news"   //只要是新闻的不管是哪个国家都接收
    ))
    public void listenTopicQueue2(String msg){
        System.out.println("消费者接收到direct.queue2的消息 : [" + msg + "]");
    }


}
