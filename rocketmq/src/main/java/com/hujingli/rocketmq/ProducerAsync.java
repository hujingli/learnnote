package com.hujingli.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 异步消息发送者
 *
 * @author exphuhong
 */
public class ProducerAsync {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("xoxogp");

        // 设置nameServer 地址
        producer.setNamesrvAddr("106.12.2.202:9876");

        producer.start();

        // topic  消息将要发送到的地址
        // body 消息中的具体数据
        Message message = new Message("MyTopic001", "第一条数据".getBytes());

        // 异步可靠消息
        // 不会阻塞，等待broker的确认，采用事件监听的方式接受broker返回的确认
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("发生异常");
                // catch异常，尝试重新投递
                e.printStackTrace();

            }
        });

//        producer.shutdown();
        System.out.println("producer 关闭");
    }

}
