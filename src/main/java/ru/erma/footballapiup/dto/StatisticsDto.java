package ru.erma.footballapiup.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StatisticsDto {
    @NotNull(message = "Goals cannot be null")
    @PositiveOrZero(message = "Goals must be a non-negative number")
    private Integer goals;

    @NotNull(message = "Assists cannot be null")
    @PositiveOrZero(message = "Assists must be a non-negative number")
    private Integer assists;

    @NotNull(message = "Yellow cards cannot be null")
    @PositiveOrZero(message = "Yellow cards must be a non-negative number")
    private Integer yellowCards;

    @NotNull(message = "Red cards cannot be null")
    @PositiveOrZero(message = "Red cards must be a non-negative number")
    private Integer redCards;
}
