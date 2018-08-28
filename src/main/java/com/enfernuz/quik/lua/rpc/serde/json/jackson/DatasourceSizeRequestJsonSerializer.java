package com.enfernuz.quik.lua.rpc.serde.json.jackson;

import com.enfernuz.quik.lua.rpc.api.messages.datasource.Size;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

final class DatasourceSizeRequestJsonSerializer extends JsonSerializer<Size.Request> {

    @Override
    public void serialize(final Size.Request value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {

        QluaJsonJacksonUtils.prepareJsonGeneratorForMethod(gen, "datasource.Size");
        gen.writeStringField("datasource_uuid", value.getDatasourceUUID());
        QluaJsonJacksonUtils.finishJsonGenerator(gen);
    }
}
