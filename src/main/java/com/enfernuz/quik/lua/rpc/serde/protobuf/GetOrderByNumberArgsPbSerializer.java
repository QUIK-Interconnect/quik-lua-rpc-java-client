package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetOrderByNumber;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum GetOrderByNumberArgsPbSerializer implements Serializer<GetOrderByNumber.Args>, ToPbConverter<GetOrderByNumber.Args, qlua.rpc.GetOrderByNumber.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final GetOrderByNumber.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.GetOrderByNumber.Request convert(@NotNull final GetOrderByNumber.Args args) {

        return qlua.rpc.GetOrderByNumber.Request.newBuilder()
                .setClassCode( args.getClassCode() )
                .setOrderId( args.getOrderId() )
                .build();
    }
}
