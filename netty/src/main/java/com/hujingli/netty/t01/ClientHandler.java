package com.hujingli.netty.t01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;

import javax.xml.ws.WebServiceClient;

/**
 * @author <a href="exphuhong@163.com>huhong<a>
 * @CreateTime 2020 年 09 月 21 日
 * @Description todo
 * @since 1.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = null;
        try{
            buf = (ByteBuf) msg; // buf需要释放
            System.out.println(buf);
            byte[] bytes = new byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(), bytes);
            System.out.println(new String(bytes));
//            System.out.println(buf.refCnt());
            ctx.close();
        }finally {
            if (buf != null) {
                ReferenceCountUtil.release(buf);
                System.out.println(buf.refCnt());
            }

        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // buf 直接内存  需要释放    writeAndFlush会自动释放
        ByteBuf buf = Unpooled.copiedBuffer("hello".getBytes());
        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        ctx.close();
    }
}
