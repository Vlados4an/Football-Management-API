package ru.erma.footballapiup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.erma.footballapiup.dto.PlayerDto;
import ru.erma.footballapiup.service.FootballApiDataService;

import java.io.IOException;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class FootballApiDataController {
    private final FootballApiDataService footballApiService;
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPersonById(@PathVariable int id) throws IOException {
        return ResponseEntity.ok(footballApiService.getPersonById(id));
    }
}
