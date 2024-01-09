package ru.erma.footballapiup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.erma.footballapiup.validators.PastOrPresentYear;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Short name should not be blank")
    private String shortName;

    @NotBlank(message = "Tla should not be blank")
    private String tla;

    @NotBlank(message = "Address should not be blank")
    private String address;

    @NotNull(message = "Founded cannot be null")
    @Positive(message = "Founded should be positive integer")
    @PastOrPresentYear(message = "Founded should be the past or present year")
    private int founded;

    @NotBlank(message = "ClubColors should not be blank")
    private String clubColors;

    @NotBlank(message = "Venue should not be blank")
    private String venue;
    private AreaDto area;

}