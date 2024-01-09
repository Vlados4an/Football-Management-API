package ru.erma.footballapiup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.erma.footballapiup.dto.AreaDto;
import ru.erma.footballapiup.service.AreaService;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {
    private final AreaService areaService;
    @GetMapping
    public ResponseEntity<List<AreaDto>> getAllAreas(){
        return ResponseEntity.ok(areaService.findAllAreas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getAreaById(@PathVariable Long id){
        return ResponseEntity.ok(areaService.findAreaById(id));
    }
}
