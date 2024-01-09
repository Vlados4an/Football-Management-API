package ru.erma.footballapiup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapiup.dto.AreaDto;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Area;
import ru.erma.footballapiup.repository.AreaRepository;
import ru.erma.footballapiup.util.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;
    private final ModelMapper mapper;
    public List<AreaDto> findAllAreas(){
        List<Area> areas = areaRepository.findAll();
        return areas.stream()
                .map(mapper::toAreaDto)
                .collect(Collectors.toList());
    }

    public AreaDto findAreaById(Long id){
        return areaRepository.findById(id)
                .map(mapper::toAreaDto)
                .orElseThrow(()->new EntityNotFoundException("Area",id));
    }
}
