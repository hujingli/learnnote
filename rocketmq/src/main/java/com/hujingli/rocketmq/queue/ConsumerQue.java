package com.hujingli.rocketmq.queue;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 消费者
 *
 * @author exphuhong
 */
public class ConsumerQue {


    public static void main(String[] args) throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumerQueueGP"); // 一个组里的consumer 不能切换 TAG
        consumer.setNamesrvAddr("106.12.2.202:9876");

        consumer.subscribe("queueTopic", "*");


        /**
         * MessageListenerOrderly 顺序消费，一个queue对应一个线程  多个对多个
         */

        // 最大开启线程数
//        consumer.setConsumeThreadMax();

        // 最小线程数
//        consumer.setConsumeThreadMin();

        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                for (MessageExt msg : msgs) {
                    System.out.println(new String(msg.getBody()) + " ,Thread:" + Thread.currentThread().getName());
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });


        consumer.start();

        System.out.println("ConsumerQue start");

    }

}
