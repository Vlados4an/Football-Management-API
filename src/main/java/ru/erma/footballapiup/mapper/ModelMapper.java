package ru.erma.footballapiup.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.erma.footballapiup.dto.*;
import ru.erma.footballapiup.model.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper {

    Player toPlayer(PlayerDto playerDto);

    PlayerDto toPlayerDto(Player player);
    TeamDto toTeamDto(Team team);

    AreaDto toAreaDto(Area area);
    ContractDto toContractDto(Contract contract);

    StatisticsDto statisticsToDto(Statistics statistics);

    Statistics toStatistics(StatisticsDto statisticsDto);

    void updatePlayerFromDto(PlayerDtoRequest playerDtoRequest, @MappingTarget Player player);

    void updateContractFromDto(ContractDto contractDto,@MappingTarget Contract contractToUpdate);

    void updateAreaFromDto(AreaDto areaDto,@MappingTarget Area areaToUpdate);

    void updateTeamFromDto(TeamDto teamDto,@MappingTarget Team teamToUpdate);


    void updateStatistics(StatisticsDto statisticsDto,@MappingTarget Statistics statisticsToUpdate);
}
