package ru.erma.footballapiup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private String name;
    private String dateOfBirth;
    private String nationality;
    private String position;
    private Integer shirtNumber;
    private TeamDto currentTeam;
    private ContractDto contract;
}
