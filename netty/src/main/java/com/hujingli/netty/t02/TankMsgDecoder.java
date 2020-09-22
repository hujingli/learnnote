package com.hujingli.netty.t02;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 22 日
 * @Description
 * @since
 */
public class TankMsgDecoder extends ByteToMessageDecoder {

    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        TankMsg tankMsg = new TankMsg();
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();
        tankMsg.setX(x);
        tankMsg.setY(y);

        list.add(tankMsg);
    }
}
