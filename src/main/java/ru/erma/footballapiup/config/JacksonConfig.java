package ru.erma.footballapiup.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.dto.TeamDto;
import ru.erma.footballapiup.serialisation.PlayerDeserializer;
import ru.erma.footballapiup.serialisation.TeamDeserializer;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(PlayerDto.class, new PlayerDeserializer(objectMapper));
        module.addDeserializer(TeamDto.class, new TeamDeserializer(objectMapper));
        objectMapper.registerModule(module);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
