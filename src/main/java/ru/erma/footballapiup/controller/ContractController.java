package ru.erma.footballapiup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.erma.footballapiup.dto.ContractDto;
import ru.erma.footballapiup.service.ContractService;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllTeams(){
        return ResponseEntity.ok(contractService.findAllContracts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ContractDto> getTeamById(@PathVariable Long id){
        return ResponseEntity.ok(contractService.findContractById(id));
    }

    @GetMapping("/expired")
    public ResponseEntity<List<ContractDto>> getContractsExpiringThisYear(){
        return ResponseEntity.ok(contractService.findContractsExpiringThisYear());
    }
}
