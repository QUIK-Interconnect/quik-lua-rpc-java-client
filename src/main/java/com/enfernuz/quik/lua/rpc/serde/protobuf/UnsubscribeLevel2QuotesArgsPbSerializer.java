package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.UnsubscribeLevel2Quotes;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;
import qlua.rpc.UnsubscribeLevelIIQuotes;

enum UnsubscribeLevel2QuotesArgsPbSerializer implements Serializer<UnsubscribeLevel2Quotes.Args>, ToPbConverter<UnsubscribeLevel2Quotes.Args, UnsubscribeLevelIIQuotes.Request> {

    INSTANCE;
    
    @NotNull
    @Override
    public byte[] serialize(@NotNull final UnsubscribeLevel2Quotes.Args args) {
        return convert(args).toByteArray();
    }

    @NotNull
    @Override
    public UnsubscribeLevelIIQuotes.Request convert(@NotNull final UnsubscribeLevel2Quotes.Args args) {
        
        return UnsubscribeLevelIIQuotes.Request.newBuilder()
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .build();
    }
}
