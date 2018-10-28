package com.enfernuz.quik.lua.rpc.api.messages;

import com.enfernuz.quik.lua.rpc.api.RemoteProcedure;
import com.enfernuz.quik.lua.rpc.api.RpcArgs;
import com.enfernuz.quik.lua.rpc.api.RpcResult;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

public final class Highlight implements RemoteProcedure {

    private Highlight() {}

    @JsonPropertyOrder({Args.T_ID, Args.ROW, Args.COL, Args.B_COLOR, Args.F_COLOR, Args.TIMEOUT})
    @EqualsAndHashCode
    public static class Args implements RpcArgs<Highlight> {

        private static final String T_ID = "t_id";
        private static final String ROW = "row";
        private static final String COL = "col";
        private static final String B_COLOR = "b_color";
        private static final String F_COLOR = "f_color";
        private static final String TIMEOUT = "timeout";

        @JsonProperty(T_ID)
        private final int tId;

        @JsonProperty(ROW)
        private final int row;

        @JsonProperty(COL)
        private final int col;

        @JsonProperty(B_COLOR)
        private final int bColor;

        @JsonProperty(F_COLOR)
        private final int fColor;

        @JsonProperty(TIMEOUT)
        private final int timeout;

        @Builder
        private Args(
                final int tId,
                final int row,
                final int col,
                final int bColor,
                final int fColor,
                final int timeout) {

            this.tId = tId;
            this.row = row;
            this.col = col;
            this.bColor = bColor;
            this.fColor = fColor;
            this.timeout = timeout;
        }

        @JsonIgnore
        public int getTId() {
            return tId;
        }

        @JsonIgnore
        public int getRow() {
            return row;
        }

        @JsonIgnore
        public int getCol() {
            return col;
        }

        @JsonIgnore
        public int getBColor() {
            return bColor;
        }

        @JsonIgnore
        public int getFColor() {
            return fColor;
        }

        @JsonIgnore
        public int getTimeout() {
            return timeout;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(T_ID, tId)
                    .add(ROW, row)
                    .add(COL, col)
                    .add(B_COLOR, bColor)
                    .add(F_COLOR, fColor)
                    .add(TIMEOUT, timeout)
                    .toString();
        }
    }

    @Value
    public static class Result implements RpcResult<Highlight> {

        private static final String RESULT = "result";

        boolean result;

        @JsonCreator
        public static Result getInstance(@JsonProperty(value = RESULT, required = true) final boolean result) {
            return result ? InstanceHolder.TRUE : InstanceHolder.FALSE;
        }

        private Result(final boolean result) {
            this.result = result;
        }

        @NotNull
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add(RESULT, result)
                    .toString();
        }

        private static final class InstanceHolder {

            private static final Result TRUE = new Result(true);
            private static final Result FALSE = new Result(false);

            // sanity check
            static {
                assert TRUE.result;
                assert !FALSE.result;
            }
        }
    }
}
