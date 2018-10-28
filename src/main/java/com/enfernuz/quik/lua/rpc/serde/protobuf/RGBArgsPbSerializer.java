package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.RGB;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

enum RGBArgsPbSerializer implements Serializer<RGB.Args>, ToPbConverter<RGB.Args, qlua.rpc.RGB.Request> {

    INSTANCE;

    @Override
    public @NotNull byte[] serialize(@NotNull final RGB.Args args) {
        return convert(args).toByteArray();
    }

    @Override
    public @NotNull qlua.rpc.RGB.Request convert(@NotNull final RGB.Args args) {

        return qlua.rpc.RGB.Request.newBuilder()
                .setRed( args.getRed() )
                .setGreen( args.getGreen() )
                .setBlue( args.getBlue() )
                .build();
    }
}
