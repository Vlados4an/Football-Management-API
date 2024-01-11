package ru.erma.footballapiup.serialisation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.erma.footballapiup.dto.*;

import java.io.IOException;

@Component
public class TeamDeserializer extends StdDeserializer<TeamDto> {
    private final ObjectMapper objectMapper;

    @Autowired
    public TeamDeserializer(ObjectMapper objectMapper) {
        this(null, objectMapper);
    }

    public TeamDeserializer(Class<?> vc, ObjectMapper objectMapper) {
        super(vc);
        this.objectMapper = objectMapper;
    }

    @Override
    public TeamDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").asText();
        int founded = node.get("founded").asInt();
        String clubColors = node.get("clubColors").asText();
        String venue = node.get("venue").asText();
        String shortName = node.get("shortName").asText();
        String tla = node.get("tla").asText();
        String address = node.get("address").asText();

        JsonNode currentAreaNode = node.get("area");
        AreaDto currentArea = objectMapper.treeToValue(currentAreaNode, AreaDto.class);

        return new TeamDto(name, shortName, tla, address, founded, clubColors, venue, currentArea);
    }
}
