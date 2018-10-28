package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetBuySellInfo;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetBuySellInfoArgsPbSerializer implements Serializer<GetBuySellInfo.Args>, ToPbConverter<GetBuySellInfo.Args, qlua.rpc.GetBuySellInfo.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetBuySellInfo.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetBuySellInfo.Request convert(@NotNull final GetBuySellInfo.Args args) {

        return qlua.rpc.GetBuySellInfo.Request.newBuilder()
                .setFirmId( args.getFirmId() )
                .setClientCode( args.getClientCode() )
                .setClassCode( args.getClassCode() )
                .setSecCode( args.getSecCode() )
                .setPrice( args.getPrice() )
                .build();
    }
}
