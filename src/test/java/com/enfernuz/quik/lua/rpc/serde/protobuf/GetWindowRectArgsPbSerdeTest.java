package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowRect;
import com.enfernuz.quik.lua.rpc.serde.Serializer;
import org.jetbrains.annotations.NotNull;

public class GetWindowRectArgsPbSerdeTest extends AbstractPbSerializationTest<GetWindowRect.Args, qlua.rpc.GetWindowRect.Request> {

    private static final int T_ID = 1;

    @Override
    public @NotNull Serializer<GetWindowRect.Args> getSerializerUnderTest() {
        return GetWindowRectArgsPbSerializer.INSTANCE;
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowRect.Request getTargetObjectAsPbMessage() {

        return qlua.rpc.GetWindowRect.Request.newBuilder()
                .setTId(T_ID)
                .build();
    }

    @NotNull
    @Override
    public GetWindowRect.Args getTargetObject() {
        return new GetWindowRect.Args(T_ID);
    }
}
