package com.hujingli.rocketmq.queue;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 消息发送者
 *
 * @author exphuhong
 */
public class ProducerQue {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("providerQueueGP");

        // 设置nameServer 地址
        producer.setNamesrvAddr("106.12.2.202:9876");

        producer.start();

        // topic  消息将要发送到的地址
        // body 消息中的具体数据

        for (int i = 0; i < 20; i++) {
            Message message = new Message("queueTopic", ("hi" + i ).getBytes());
            SendResult send = producer.send(message,

                    // queue 选择器， 向topic中的哪个queue写消息
                    new MessageQueueSelector() {
                        // 手动选择一个queue
                        @Override
                        public MessageQueue select(List<MessageQueue> queues, Message message, Object o) {
                            return queues.get(0);
                        }
                    }, "", 2000
            );

            System.out.println(send);
        }


        producer.shutdown();
        System.out.println("producer 关闭");
    }

}
