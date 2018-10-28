package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.CreateWindow;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum CreateWindowArgsPbSerializer implements Serializer<CreateWindow.Args>, ToPbConverter<CreateWindow.Args, qlua.rpc.CreateWindow.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final CreateWindow.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.CreateWindow.Request convert(@NotNull final CreateWindow.Args args) {

        return qlua.rpc.CreateWindow.Request.newBuilder()
                .setTId( args.getTId() )
                .build();
    }
}
