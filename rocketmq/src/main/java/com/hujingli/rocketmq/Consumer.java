package com.hujingli.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消费者
 *
 * @author exphuhong
 */
public class Consumer {


    public static void main(String[] args) throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xxoocsm"); // 一个组里的consumer 不能切换 TAG
        consumer.setNamesrvAddr("106.12.2.202:9876");

        //每个consumer 关注一个topic

        // topic 关注的消息地址
        // 过滤器 * 不过滤   消费者通过过滤器区分消息TAG，只接受对应TAG的消息
        consumer.subscribe("MyTopic001", "*");


        // messageSelector  也可以做过滤   需要设置服务器broker enablePropertyFilter=true
//        MessageSelector messageSelector = MessageSelector.bySql("xx > xx and xx < xx");
//        consumer.subscribe("MyTopic0012", messageSelector);

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()));
                }

                // 默认情况下 这条消息只会被一个consumer消费到点对点
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 消费模式 1、集群模式  2、 广播模式
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setMessageModel(MessageModel.CLUSTERING); // 默认采用集群模式
        consumer.start();

        System.out.println("Consumer start");

    }

}
