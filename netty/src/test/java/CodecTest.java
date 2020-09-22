import com.hujingli.netty.t02.TankMsg;
import com.hujingli.netty.t02.TankMsgDecoder;
import com.hujingli.netty.t02.TankMsgEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 22 日
 * @Description
 * @since
 */
public class CodecTest {

    @Test
    public void testEncoder() {
        EmbeddedChannel channel = new EmbeddedChannel(new TankMsgEncoder());
        TankMsg msg = new TankMsg();
        msg.setX(1);
        msg.setY(2);

        channel.writeOutbound(msg);

        Object o = channel.readOutbound();
        ByteBuf byteBuf = (ByteBuf) o;
        System.out.println(byteBuf.readInt());
        System.out.println(byteBuf.readInt());
    }

    @Test
    public void testDecoder() {

        EmbeddedChannel channel1 = new EmbeddedChannel(new TankMsgDecoder());

        ByteBuf buffer = Unpooled.buffer();
        buffer.writeInt(1);
        buffer.writeInt(2);
        channel1.writeInbound(buffer);

        Object o1 = channel1.readInbound();

        TankMsg msg = (TankMsg) o1;
        Assert.assertEquals(1, msg.getX());
        Assert.assertEquals(2, msg.getY());

    }


}
