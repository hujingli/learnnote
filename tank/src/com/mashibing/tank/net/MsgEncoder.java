package com.mashibing.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MsgEncoder extends MessageToByteEncoder<Msg>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf buf) throws Exception {
		buf.writeInt(msg.getMsgType().ordinal()); // 消息的类型  先写4个字节

		byte[] bytes = msg.toBytes(); // 获取消息的字节长度
		buf.writeInt(bytes.length); // 消息长度也是4个字节
		buf.writeBytes(bytes);
	}
	

}
