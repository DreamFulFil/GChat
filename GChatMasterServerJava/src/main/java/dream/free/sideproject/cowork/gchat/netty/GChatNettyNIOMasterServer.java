package dream.free.sideproject.cowork.gchat.netty;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 
 * @author George-Chou
 *
 * TODO:確實理解後要再調整
 */
@Component
public class GChatNettyNIOMasterServer {
    
    @Value("${gchat.master.server.port}")
    private int port;
    
    //用來接收Connection
    private EventLoopGroup bossGroup = new NioEventLoopGroup();  
    //處理bossGroup收到的Connection後續動作
    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    
    @PostConstruct
    public void run() throws Exception {
        try {
            //sets up a server
            ServerBootstrap serverBootStrap = new ServerBootstrap();
            serverBootStrap
             .group(bossGroup, workerGroup)
             .channel(NioServerSocketChannel.class)
             .childHandler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel socketChannel) throws Exception {
                     //設定Handler
                     socketChannel.pipeline().addLast(new GChatNettyNIOMasterServerHandler());
                 }
             })
             .option(ChannelOption.SO_BACKLOG, 128)
             .childOption(ChannelOption.SO_KEEPALIVE, true);
    
            // Bind and start to accept incoming connections.
            ChannelFuture f = serverBootStrap.bind(port).sync();
    
            // Wait until the server socket is closed.
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    
    @PreDestroy
    private void cleanUp() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }
}