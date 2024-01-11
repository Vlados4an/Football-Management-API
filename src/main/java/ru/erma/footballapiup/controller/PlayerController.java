package ru.erma.footballapiup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.dto.PlayerDtoRequest;
import ru.erma.footballapiup.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id){
        return ResponseEntity.ok(playerService.findPlayerById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String name){
        return ResponseEntity.ok(playerService.findPlayerByName(name));
    }

    @GetMapping("/expired")
    public ResponseEntity<List<PlayerDto>> getPlayersWithExpiredContract(){
        return ResponseEntity.ok(playerService.findPlayersWithExpiredContract());
    }

    @PutMapping("/{playerId}/statistics/{statisticsId}")
    public ResponseEntity<HttpStatus> addStatisticsToPlayer(@PathVariable Long playerId, @PathVariable Long statisticsId){
        playerService.addStatisticsToPlayer(playerId, statisticsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePlayer(@PathVariable Long id,
                                                   @RequestBody @Valid PlayerDtoRequest playerDto){
        playerService.updatePlayer(playerDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayerById(@PathVariable Long id){
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
