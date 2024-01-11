package ru.erma.footballapiup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapiup.dto.StatisticsDto;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Player;
import ru.erma.footballapiup.model.Statistics;
import ru.erma.footballapiup.repository.PlayerRepository;
import ru.erma.footballapiup.repository.StatisticsRepository;
import ru.erma.footballapiup.util.EntityNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;
    private final PlayerRepository playerRepository;
    private final ModelMapper mapper;
    public List<StatisticsDto> findAllStatistics(){
        List<Statistics> statisticsToSave = statisticsRepository.findAll();
        return statisticsToSave.stream()
                .map(mapper::statisticsToDto)
                .collect(Collectors.toList());
    }

    public void saveStatistics(StatisticsDto statisticsDto){
        Statistics statisticsToSave = mapper.toStatistics(statisticsDto);
        statisticsRepository.save(statisticsToSave);
    }

    public void updateStatisticsById(StatisticsDto statisticsDto,Long id){
        Statistics statisticsToUpdate = statisticsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Statistics not found with id: " + id));
        mapper.updateStatistics(statisticsDto,statisticsToUpdate);
        statisticsRepository.save(statisticsToUpdate);
    }

    public void deleteStatistics(Long id){
        statisticsRepository.deleteById(id);
    }

}
