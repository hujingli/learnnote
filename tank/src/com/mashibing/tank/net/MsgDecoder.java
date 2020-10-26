package com.mashibing.tank.net;

import java.util.List;
import java.util.UUID;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MsgDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if(in.readableBytes() < 8) return; // 判断消息头的长度是否正常

		// 标记读指针的位置
		in.markReaderIndex();
		
		MsgType msgType = MsgType.values()[in.readInt()];
		int length = in.readInt();

		// 判断消息读完没有 如果没有读完则等
		if(in.readableBytes()< length) {
			in.resetReaderIndex();
			return;
		}


		// 消息读完之后进行处理
		byte[] bytes = new byte[length];
		in.readBytes(bytes);
		
		Msg msg = null;
		
		//reflection
		msg = (Msg)Class.forName("com.mashibing.tank.net." + msgType.toString() + "Msg").getDeclaredConstructor().newInstance();
		/*switch(msgType) {
		case TankJoin:
			msg = new TankJoinMsg();
			break;
		case TankStartMoving:
			msg = new TankStartMovingMsg();
			break;
		case TankStop:
			msg = new TankStopMsg();
			break;
		case Tank
		default:
			break;
		}*/
		
		msg.parse(bytes);
		out.add(msg);
		
	}

}
