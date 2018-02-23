package com.enfernuz.quik.lua.rpc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;

public enum JsonClientConfigurationReader implements ObjectReader<ClientConfiguration> {

    INSTANCE;

    private final ObjectMapper objectMapper;

    private JsonClientConfigurationReader() {

        final SimpleModule module = new SimpleModule();
        module.addDeserializer(SimpleClientConfiguration.class, new SimpleClientConfigurationJsonDeserializer());

        this.objectMapper = new ObjectMapper().registerModule(module);
    }

    @Override
    public ClientConfiguration read(final File file) throws IOException {
        return objectMapper.readValue(file, SimpleClientConfiguration.class);
    }
}
