package ru.erma.footballapiup.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
        module.addDeserializer(PlayerDto.class, new PlayerDeserializer());
        module.addDeserializer(TeamDto.class, new TeamDeserializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
