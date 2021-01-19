package com.hujingli.netty.herostory;

import com.google.protobuf.GeneratedMessageV3;
import com.hujingli.netty.herostory.msg.GameMsgProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameMsgHandler extends SimpleChannelInboundHandler<Object> {

    /**
     * 信道组
     */
    private static ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static Map<Integer, User> USER_MAP = new ConcurrentHashMap<>();


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        CHANNEL_GROUP.add(ctx.channel());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        if (o == null || ctx == null) {
            return;
        }
        if (!(o instanceof GeneratedMessageV3)) {
            return;
        }

        System.out.println(o);
        GameMsgProtocol.UserEntryResult.Builder userEntryResultBuilder = GameMsgProtocol.UserEntryResult.newBuilder();
        if (o instanceof GameMsgProtocol.UserEntryCmd) {
            GameMsgProtocol.UserEntryCmd entryCmd = (GameMsgProtocol.UserEntryCmd) o;
            int userId = entryCmd.getUserId();
            String heroAvatar = entryCmd.getHeroAvatar();
            User user = new User();
            user.setUserId(userId);
            user.setHeroAvatar(heroAvatar);
            USER_MAP.putIfAbsent(userId, user);
            userEntryResultBuilder.setUserId(userId);
            userEntryResultBuilder.setHeroAvatar(heroAvatar);
            GameMsgProtocol.UserEntryResult userEntryResult = userEntryResultBuilder.build();
            // 广播
            CHANNEL_GROUP.writeAndFlush(userEntryResult);
        } else if (o instanceof GameMsgProtocol.WhoElseIsHereCmd) {
            GameMsgProtocol.WhoElseIsHereCmd whoElseIsHereCmd = (GameMsgProtocol.WhoElseIsHereCmd) o;
            GameMsgProtocol.WhoElseIsHereResult.Builder builder = GameMsgProtocol.WhoElseIsHereResult.newBuilder();

            USER_MAP.forEach((k, v) -> {
                GameMsgProtocol.WhoElseIsHereResult.UserInfo.Builder userInfoBuilder = GameMsgProtocol.WhoElseIsHereResult.UserInfo.newBuilder();
                userInfoBuilder.setUserId(v.getUserId());
                userInfoBuilder.setHeroAvatar(v.getHeroAvatar());
                GameMsgProtocol.WhoElseIsHereResult.UserInfo userInfo = userInfoBuilder.build();
                builder.addUserInfo(userInfo);
            });
            GameMsgProtocol.WhoElseIsHereResult whoElseIsHereResult = builder.build();
            ctx.writeAndFlush(whoElseIsHereResult);
        }


    }
}
