package ru.erma.footballapiup.serialisation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.erma.footballapiup.dto.*;

import java.io.IOException;

public class TeamDeserializer extends StdDeserializer<TeamDto> {

    public TeamDeserializer() {
        this(null);
    }

    public TeamDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TeamDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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