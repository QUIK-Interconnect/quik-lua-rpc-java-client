package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetCandlesByIndex;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetCandlesByIndexArgsPbSerializer implements Serializer<GetCandlesByIndex.Args>, ToPbConverter<GetCandlesByIndex.Args, qlua.rpc.GetCandlesByIndex.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetCandlesByIndex.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetCandlesByIndex.Request convert(@NotNull final GetCandlesByIndex.Args args) {

        return qlua.rpc.GetCandlesByIndex.Request.newBuilder()
                .setTag( args.getTag() )
                .setLine( args.getLine() )
                .setFirstCandle( args.getFirstCandle() )
                .setCount( args.getCount() )
                .build();
    }
}
