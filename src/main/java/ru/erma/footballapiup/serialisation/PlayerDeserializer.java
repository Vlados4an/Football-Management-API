package ru.erma.footballapiup.serialisation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.erma.footballapiup.dto.ContractDto;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.dto.TeamDto;

import java.io.IOException;

public class PlayerDeserializer extends StdDeserializer<PlayerDto> {

    public PlayerDeserializer() {
        this(null);
    }

    public PlayerDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PlayerDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = objectMapper.readTree(jp);
        String name = node.get("name").asText();
        String dateOfBirth = node.get("dateOfBirth").asText();
        String nationality = node.get("nationality").asText();
        String position = node.get("position").asText();
        int shirtNumber = node.get("shirtNumber").asInt();

        JsonNode currentTeamNode = node.get("currentTeam");
        TeamDto currentTeam = objectMapper.treeToValue(currentTeamNode, TeamDto.class);

        JsonNode contractNode = currentTeamNode.get("contract"); // Get contract from currentTeam
        ContractDto contract = objectMapper.treeToValue(contractNode, ContractDto.class);

        return new PlayerDto(name, dateOfBirth, nationality, position, shirtNumber, currentTeam, contract);
    }
}