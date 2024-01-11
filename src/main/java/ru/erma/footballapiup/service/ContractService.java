package ru.erma.footballapiup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapiup.dto.ContractDto;
import ru.erma.footballapiup.mapper.ModelMapper;
import ru.erma.footballapiup.model.Contract;
import ru.erma.footballapiup.repository.ContractRepository;
import ru.erma.footballapiup.util.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;
    private final ModelMapper mapper;

    public List<ContractDto> findAllContracts(){
        List<Contract> contracts = contractRepository.findAll();
        return contracts.stream()
                .map(mapper::toContractDto)
                .collect(Collectors.toList());
    }

    public ContractDto findContractById(Long id){
        return contractRepository.findById(id)
                .map(mapper::toContractDto)
                .orElseThrow(()-> new EntityNotFoundException("Contract",id));
    }
    public List<ContractDto> findContractsExpiringThisYear(){
        int currentYear = LocalDate.now().getYear();
        List<Contract> contracts = contractRepository.findContractsExpiringThisYear(currentYear);
        return contracts.stream()
                .map(mapper::toContractDto)
                .collect(Collectors.toList());
    }
}
