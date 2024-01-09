package ru.erma.footballapiup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapiup.dto.*;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Area;
import ru.erma.footballapiup.model.Team;
import ru.erma.footballapiup.repository.TeamRepository;
import ru.erma.footballapiup.util.EntityNotFoundException;
import ru.erma.footballapiup.util.TeamNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    public List<TeamDto> findAllTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(mapper::toTeamDto)
                .collect(Collectors.toList());
    }

    public TeamDto findTeamById(Long id){
        return teamRepository.findById(id)
                .map(mapper::toTeamDto)
                .orElseThrow(()-> new EntityNotFoundException("Team",id));
    }

    public TeamDto findTeamByName(String name){
        return teamRepository.findByName(name)
                .map(mapper::toTeamDto)
                .orElseThrow(()-> new TeamNotFoundException(name));
    }

    public void updateTeam(TeamDto teamDto, Long id){
        Team teamToUpdate = teamRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Team",id));
        Area areaToUpdate = teamToUpdate.getArea();
        AreaDto areaDto = teamDto.getArea();
        mapper.updateAreaFromDto(areaDto, areaToUpdate);
        mapper.updateTeamFromDto(teamDto, teamToUpdate);
        teamRepository.save(teamToUpdate);
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }


}
