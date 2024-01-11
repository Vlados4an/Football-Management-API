package ru.erma.footballapiup.serialisation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.erma.footballapiup.dto.ContractDto;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.dto.TeamDto;

import java.io.IOException;
@Component
public class PlayerDeserializer extends StdDeserializer<PlayerDto> {
    private final ObjectMapper objectMapper;

    @Autowired
    public PlayerDeserializer(ObjectMapper objectMapper) {
        this(null, objectMapper);
    }

    public PlayerDeserializer(Class<?> vc, ObjectMapper objectMapper) {
        super(vc);
        this.objectMapper = objectMapper;
    }

    @Override
    public PlayerDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = objectMapper.readTree(jp);
        String name = node.get("name").asText();
        String dateOfBirth = node.get("dateOfBirth").asText();
        String nationality = node.get("nationality").asText();
        String position = node.get("position").asText();
        int shirtNumber = node.get("shirtNumber").asInt();

        JsonNode currentTeamNode = node.get("currentTeam");
        TeamDto currentTeam = objectMapper.treeToValue(currentTeamNode, TeamDto.class);

        JsonNode contractNode = currentTeamNode.get("contract");
        ContractDto contract = objectMapper.treeToValue(contractNode, ContractDto.class);

        return new PlayerDto(name, dateOfBirth, nationality, position, shirtNumber, currentTeam, contract);
    }
}