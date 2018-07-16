package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.events.api.structures.QuoteEventInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static com.enfernuz.quik.lua.rpc.serde.json.jackson.QluaJsonJacksonUtils.asText;

final class QuoteEventInfoJsonDeserializer extends JsonDeserializer<QuoteEventInfo> {

    @Override
    public QuoteEventInfo deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {

        final JsonNode node = p.getCodec().readTree(p);
        return QuoteEventInfo
                .builder()
                .classCode( asText(node, "class_code") )
                .secCode( asText(node, "sec_code") )
                .build();
    }
}
