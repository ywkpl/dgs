package com.dotest.dsg.config;

import org.springframework.boot.jackson.autoconfigure.JsonMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.core.json.JsonWriteFeature;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigInteger;

//@Configuration
public class JacksonConfig {
//    @Bean
//    public JsonMapperBuilderCustomizer jsonMapperBuilderCustomizer() {
//        return builder -> {
//            // 將 Long 類型（包括基本類型和包裝類）序列化為 String
//            builder.addModule(new SimpleModule()
//                    .addSerializer(Long.class, ToStringSerializer.instance)
//                    .addSerializer(Long.TYPE, ToStringSerializer.instance)
//                    .addSerializer(BigInteger.class, ToStringSerializer.instance)
//            );
//        };
//        return builder -> {
//            builder.configure(JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS, true);
//        };
//    }
}
