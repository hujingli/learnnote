package com.hujingli.rocketmq.tx;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 消息发送者
 *
 * @author exphuhong
 */
public class ProducerTx {

    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("txprovider");

        // 设置nameServer 地址
        producer.setNamesrvAddr("106.12.2.202:9876");

//        producer.setExecutorService();  // 可设置线程池


        // 设置事务回调
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {

                System.out.println("======executeLocalTransaction");
                System.out.println("msg:" + new String(message.getBody()));
                System.out.println("transaction_id:" + message.getTransactionId());

                try {
                    //执行业务
                } catch (Exception e) {
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }

                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                // broker 端回调，检查事务
                System.out.println("======checkLocalTransaction");
                System.out.println("msg:" + new String(messageExt.getBody()));
                System.out.println("transaction_id:" + messageExt.getTransactionId());


                // 事务执行成功
//                return LocalTransactionState.COMMIT_MESSAGE;

                // 未知
                return LocalTransactionState.UNKNOW;

                // 回滚
//                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });

        producer.start();

        // topic  消息将要发送到的地址
        // body 消息中的具体数据
        Message message = new Message("txprovider001", "事务消息测试".getBytes());

//        message.putUserProperty(); // 可以把消息变成有结构的  消费者通过过滤器 messageSelector过滤

//        producer.setRetryTimesWhenSendFailed(1);   // 同步发送消息的时候重试几次
//        producer.setRetryTimesWhenSendAsyncFailed(1);  // 异步发送消息的时候崇重试几次
//        producer.setRetryAnotherBrokerWhenNotStoreOK(true);   // broker 坏掉  换一个发


        SendResult result = producer.sendMessageInTransaction(message, null);

        System.out.println("result" + result);
//        producer.shutdown();
//        System.out.println("producer 关闭");
    }

}
