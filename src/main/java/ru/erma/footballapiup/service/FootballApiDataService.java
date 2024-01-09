package ru.erma.footballapiup.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Area;
import ru.erma.footballapiup.model.Player;
import ru.erma.footballapiup.model.Team;
import ru.erma.footballapiup.repository.*;


import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballApiDataService {
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private final ModelMapper mapper;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final AreaRepository areaRepository;
    private final ContractRepository contractRepository;
    private final ObjectMapper objectMapper;

    public PlayerDto getPersonById(int id) throws IOException {
        String response = makeHttpRequest(id);
        PlayerDto playerDto = parseResponse(response);
        saveData(playerDto);
        return playerDto;
    }

    private String makeHttpRequest(int id) {
            HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

            ResponseEntity<String> response = restTemplate.exchange(
                    "https://api.football-data.org/v4/persons/" + id,
                    HttpMethod.GET,
                    entity,
                    String.class);

            return response.getBody();
    }

    private PlayerDto parseResponse(String response) throws IOException {
            return objectMapper.readValue(response, PlayerDto.class);
    }

    private void saveData(PlayerDto playerDto) {
            Player player = mapper.toPlayer(playerDto);
            Team team = player.getCurrentTeam();

            Optional<Player> existingPlayer = playerRepository.findByName(player.getName());
            if (existingPlayer.isPresent()) {
                return;
            }

            saveArea(team);

            if(player.getContract() != null) {
                contractRepository.save(player.getContract());
            }

            saveTeam(player, team);

            playerRepository.save(player);
        }

    private void saveArea(Team team) {
        Optional<Area> existingArea = areaRepository.findByName(team.getArea().getName());
        if (existingArea.isPresent()) {
            team.setArea(existingArea.get());
        } else {
            areaRepository.save(team.getArea());
        }
    }

    private void saveTeam(Player player, Team team) {
        Optional<Team> existingTeam = teamRepository.findByName(team.getName());
        if (existingTeam.isPresent()) {
            player.setCurrentTeam(team);
        } else {
            team = teamRepository.save(team);
            player.setCurrentTeam(team);
        }
    }
}