package com.hujingli.netty.herostory;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class GameMsgHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        System.out.println(o);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello".getBytes()));
    }
}
