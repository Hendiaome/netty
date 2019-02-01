package io.netty.example.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 描述
 *
 * @author zhaotianming1
 * @date 2019/1/31
 */
public class EchoServerDeCoderHandler extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if (in.writerIndex() == 8) {
            String e = in.toString(Charset.defaultCharset());
            out.add(e);
            in.readerIndex(8);
        }
    }
}
