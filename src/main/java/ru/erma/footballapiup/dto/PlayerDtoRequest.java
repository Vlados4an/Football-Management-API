package ru.erma.footballapiup.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDtoRequest {
    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Date of birth should not be blank")
    private String dateOfBirth;

    @NotBlank(message = "Nationality should not be blank")
    private String nationality;

    @NotBlank(message = "Position should not be blank")
    private String position;

    @NotNull(message = "ShirtNumber cannot be null")
    @Positive(message = "ShirtNumber should be positive integer")
    @Max(value = 99,message = "ShirtNumber should be less than 100")
    private Integer shirtNumber;

    private ContractDto contract;
}
