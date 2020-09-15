package com.hujingli.netty.t01;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author <a href="exphuhong@163.com>huhong<a>
 * @CreateTime 2020 年 09 月 14 日
 * @Description todo
 * @since 1.0
 *
 */
public class Client {

    public static void main(String[] args) {
        // 线程池
        EventLoopGroup group = new NioEventLoopGroup();

        // 辅助启动类
        Bootstrap bootstrap = new Bootstrap();

        try {
            ChannelFuture future = bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientChannelInitializer())
                    .connect("localhost", 8888);

            // 如果连接完成了注册的监听器会立即执行
            future.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("Connected!");
                    } else {
                        System.out.println("not Connected!");
                    }
                }
            });

            // 阻塞
            future.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

}

class ClientChannelInitializer extends ChannelInitializer {

    protected void initChannel(Channel channel) throws Exception {

    }
}
