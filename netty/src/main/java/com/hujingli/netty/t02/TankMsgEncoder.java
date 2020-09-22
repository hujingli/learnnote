package com.hujingli.netty.t02;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 22 日
 * @Description
 * @since
 */
public class TankMsgEncoder extends MessageToByteEncoder<TankMsg> {

    protected void encode(ChannelHandlerContext channelHandlerContext, TankMsg tankMsg, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(tankMsg.getX());
        byteBuf.writeInt(tankMsg.getY());
    }
}
