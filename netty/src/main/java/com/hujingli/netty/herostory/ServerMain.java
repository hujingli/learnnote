package com.hujingli.netty.herostory;

import com.hujingli.netty.herostory.codec.GameMsgDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class ServerMain {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup);
        try {
            bootstrap.channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new HttpServerCodec(),
                                    new HttpObjectAggregator(65536),
                                    new WebSocketServerProtocolHandler("/websocket"),
                                    new GameMsgDecoder(),
                                    new GameMsgHandler());
                        }
                    });
//            bootstrap.childOption(ChannelOption.SO_BACKLOG, 128);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = bootstrap.bind(12345);
            future.sync();
            if (future.isSuccess()) {
                System.out.println("游戏服务器启动成功");
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
