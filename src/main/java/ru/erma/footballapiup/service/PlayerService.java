package ru.erma.footballapiup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapiup.dto.ContractDto;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.dto.PlayerDtoRequest;
import ru.erma.footballapiup.dto.StatisticsDto;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Contract;
import ru.erma.footballapiup.model.Player;
import ru.erma.footballapiup.model.Statistics;
import ru.erma.footballapiup.model.Team;
import ru.erma.footballapiup.repository.PlayerRepository;
import ru.erma.footballapiup.repository.StatisticsRepository;
import ru.erma.footballapiup.util.EntityNotFoundException;
import ru.erma.footballapiup.util.PlayerNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final StatisticsRepository statisticsRepository;
    private final ModelMapper mapper;

    public List<PlayerDto> findAllPlayers(){
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(mapper::toPlayerDto)
                .collect(Collectors.toList());
    }
    public PlayerDto findPlayerById(Long id){
        return playerRepository.findById(id)
                .map(mapper::toPlayerDto)
                .orElseThrow(()-> new EntityNotFoundException("Player",id));
    }

    public PlayerDto findPlayerByName(String name){
        return playerRepository.findByName(name)
                .map(mapper::toPlayerDto)
                .orElseThrow(()-> new PlayerNotFoundException(name));
    }

    public void addStatisticsToPlayer(Long playerId, Long statisticsId){
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player", playerId));
        Statistics statistics = statisticsRepository.findById(statisticsId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics", statisticsId));
        player.setStatistics(statistics);
        playerRepository.save(player);
    }

    public void updatePlayer(PlayerDtoRequest playerDtoRequest, Long id){
        Player playerToUpdate = playerRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Player",id));
        Team currentTeam = playerToUpdate.getCurrentTeam();
        Contract contractToUpdate = playerToUpdate.getContract();
        ContractDto contractDto = playerDtoRequest.getContract();
        mapper.updateContractFromDto(contractDto, contractToUpdate);
        mapper.updatePlayerFromDto(playerDtoRequest, playerToUpdate);
        playerToUpdate.setCurrentTeam(currentTeam);
        playerRepository.save(playerToUpdate);
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }

}
