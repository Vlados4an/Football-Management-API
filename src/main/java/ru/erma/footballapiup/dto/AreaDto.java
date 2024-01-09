package ru.erma.footballapiup.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaDto {
    @NotBlank(message = "Name should not be blank")
    private String name;

    @NotBlank(message = "Code should not be blank")
    private String code;

    @NotBlank(message = "Flag should not be blank")
    private String flag;
}
