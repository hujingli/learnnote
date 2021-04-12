package com.hujingli.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 消息发送者
 *
 * @author exphuhong
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("xoxogp");

        // 设置nameServer 地址
        producer.setNamesrvAddr("106.12.2.202:9876");

        producer.start();

        // topic  消息将要发送到的地址
        // body 消息中的具体数据
        Message message = new Message("MyTopic001", "第一条数据".getBytes());

//        message.putUserProperty(); 可以把消息变成有结构的  消费者通过过滤器 messageSelector过滤

        SendResult result = producer.send(message);

        System.out.println(result);
        producer.shutdown();
        System.out.println("producer 关闭");
    }

}
