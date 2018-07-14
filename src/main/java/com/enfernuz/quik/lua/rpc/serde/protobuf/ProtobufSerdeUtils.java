package com.enfernuz.quik.lua.rpc.serde.protobuf;

import com.google.common.base.Strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ProtobufSerdeUtils {

    static final Charset DEFAULT_PROTOBUF_CHARSET = StandardCharsets.UTF_8;

    private ProtobufSerdeUtils() {
        throw new AssertionError("This should never be invoked.");
    }

    static String nullIfNullOrEmpty(final String str) {
        return Strings.isNullOrEmpty(str) ? null : str;
    }
}
