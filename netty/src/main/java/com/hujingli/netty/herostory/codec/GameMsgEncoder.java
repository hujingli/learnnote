package com.hujingli.netty.herostory.codec;

import com.google.protobuf.GeneratedMessageV3;
import com.hujingli.netty.herostory.msg.GameMsgProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

public class GameMsgEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (ctx == null || !(msg instanceof GeneratedMessageV3)) {
            super.write(ctx, msg, promise);
            return;
        }

        int msgCode = -1;

        ByteBuf byteBuf = ctx.alloc().buffer();
        if (msg instanceof GameMsgProtocol.UserEntryResult) {
            msgCode = GameMsgProtocol.MsgCode.USER_ENTRY_RESULT_VALUE;
        } else if (msg instanceof GameMsgProtocol.WhoElseIsHereResult) {
            msgCode = GameMsgProtocol.MsgCode.WHO_ELSE_IS_HERE_RESULT_VALUE;
        }
        byte[] body = ((GeneratedMessageV3) msg).toByteArray();
        byteBuf.writeShort((short) body.length);
        byteBuf.writeShort((short) msgCode);
        byteBuf.writeBytes(body);

        // ×ª³ÉBinaryWebsocketFrame
        BinaryWebSocketFrame webSocketFrame = new BinaryWebSocketFrame(byteBuf);
        ctx.write(webSocketFrame);
    }
}
