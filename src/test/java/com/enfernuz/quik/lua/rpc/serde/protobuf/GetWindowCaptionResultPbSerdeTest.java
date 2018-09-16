package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.enfernuz.quik.lua.rpc.api.messages.GetWindowCaption;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class GetWindowCaptionResultPbSerdeTest extends AbstractResultPbSerdeTest<GetWindowCaption.Result, qlua.rpc.GetWindowCaption.Result> {

    @Override
    public @NotNull Class<GetWindowCaption.Result> getTargetObjectClass() {
        return GetWindowCaption.Result.class;
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowCaption.Result getTargetObjectAsPbMessage() {

        return qlua.rpc.GetWindowCaption.Result.newBuilder()
                .setCaption(WindowCaptionParameters.CAPTION)
                .build();
    }

    @NotNull
    @Override
    public GetWindowCaption.Result getTargetObject() {
        return GetWindowCaption.Result.getInstance(WindowCaptionParameters.CAPTION);
    }

    @Test
    @Override
    public void shouldSerialize_ErrorObject_To_ByteArrayOf_PbErrorObject() {
        super.shouldSerialize_ErrorObject_To_ByteArrayOf_PbErrorObject();
    }

    @Test
    @Override
    public void shouldDeserialize_ByteArrayOf_PbErrorObject_To_ErrorObject() {
        super.shouldDeserialize_ByteArrayOf_PbErrorObject_To_ErrorObject();
    }

    @NotNull
    @Override
    public qlua.rpc.GetWindowCaption.Result getErrorObject_AsPbMessage() {
        return qlua.rpc.GetWindowCaption.Result.newBuilder().build();
    }

    @NotNull
    @Override
    public GetWindowCaption.Result getErrorObject() {
        return GetWindowCaption.Result.getErrorInstance();
    }

    private static final class WindowCaptionParameters {

        private static final String CAPTION = "1";
    }
}
