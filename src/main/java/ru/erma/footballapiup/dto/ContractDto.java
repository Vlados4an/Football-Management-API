package ru.erma.footballapiup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    @NotBlank(message = "Start should not be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}$", message = "Start should be in the format 'YYYY-MM'")
    private String start;

    @NotBlank(message = "Until should not be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}$", message = "Until should be in the format 'YYYY-MM'")
    private String until;
}
