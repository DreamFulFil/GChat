package dream.free.sideproject.cowork.gchat.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 
 * @author George-Chou
 *
 */
public class GChatNettyNIOMasterServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //TODO: 改類別命名，改實作。
//        ByteBuf in = (ByteBuf)msg;
//        try {
            // Do something with msg
//            while(in.isReadable()) {
//                System.err.print((char)in.readByte());
//                System.err.flush();
//            }
            ctx.write(msg);
            ctx.flush();
//        } finally {
//            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // TODO Auto-generated method stub
        super.exceptionCaught(ctx, cause);
    }

}
