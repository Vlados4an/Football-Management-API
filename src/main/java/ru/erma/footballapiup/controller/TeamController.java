package ru.erma.footballapiup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapiup.dto.TeamDto;
import ru.erma.footballapiup.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        return ResponseEntity.ok(teamService.findAllTeams());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id){
        return ResponseEntity.ok(teamService.findTeamById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TeamDto> getTeamByName(@PathVariable String name){
        return ResponseEntity.ok(teamService.findTeamByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateTeam(@PathVariable Long id,
                                                 @RequestBody @Valid TeamDto teamDto){
        teamService.updateTeam(teamDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
