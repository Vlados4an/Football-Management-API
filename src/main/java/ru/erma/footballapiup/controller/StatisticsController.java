package ru.erma.footballapiup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapiup.dto.StatisticsDto;
import ru.erma.footballapiup.service.StatisticsService;

import java.util.List;


@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;
    @GetMapping
    public ResponseEntity<List<StatisticsDto>> getAllStatistics(){
        return ResponseEntity.ok(statisticsService.findAllStatistics());
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveStatistics(@RequestBody StatisticsDto statisticsDto){
        statisticsService.saveStatistics(statisticsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateStatistics(
            @RequestBody @Valid StatisticsDto statisticsDto,@PathVariable Long id){
        statisticsService.updateStatisticsById(statisticsDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStatisticsById(@PathVariable Long id){
        statisticsService.deleteStatistics(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
