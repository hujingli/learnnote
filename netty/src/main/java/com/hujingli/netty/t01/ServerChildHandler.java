package com.hujingli.netty.t01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author <a href="exphuhong@163.com>huhong<a>
 * @CreateTime 2020 年 09 月 21 日
 * @Description todo
 * @since 1.0
 */
@ChannelHandler.Sharable
public class ServerChildHandler extends ChannelInboundHandlerAdapter {

    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 所有客户端保存到通道组
        clients.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = null;
        try{
            buf = (ByteBuf) msg; // buf需要释放
            System.out.println(buf);
            byte[] bytes = new byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(), bytes);
            System.out.println(new String(bytes));
//            ctx.writeAndFlush(msg);
            clients.writeAndFlush(msg);
            ctx.close();
        }finally {
            /*if (buf != null) {
                ReferenceCountUtil.release(buf);
                System.out.println(buf.refCnt());
            }*/
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        clients.remove(ctx.channel());
        ctx.close();
    }
}
