package com.hujingli.netty.herostory.codec;

import com.google.protobuf.GeneratedMessageV3;
import com.hujingli.netty.herostory.msg.GameMsgProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

public class GameMsgDecoder extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg == null || ctx == null) {
            return;
        }
        if (!(msg instanceof BinaryWebSocketFrame)) {
            return;
        }

        try {
            BinaryWebSocketFrame binaryWebSocketFrame = (BinaryWebSocketFrame) msg;
            ByteBuf byteBuf = binaryWebSocketFrame.content();
            byteBuf.readShort();
            int msgCode = byteBuf.readShort();
            byte[] body = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(body);
            GeneratedMessageV3 cmd = null;
            switch (msgCode) {
                case GameMsgProtocol.MsgCode.USER_ENTRY_CMD_VALUE:
                    cmd = GameMsgProtocol.UserEntryCmd.parseFrom(body);
                    break;
                case GameMsgProtocol.MsgCode.WHO_ELSE_IS_HERE_CMD_VALUE:
                    cmd = GameMsgProtocol.WhoElseIsHereCmd.parseFrom(body);
                    break;
                default:
                    break;
            }
            if (cmd != null) {
                ctx.fireChannelRead(cmd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
