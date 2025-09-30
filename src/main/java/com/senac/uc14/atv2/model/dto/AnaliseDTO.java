package com.senac.uc14.atv2.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AnaliseDTO(
        @NotNull(message = "ID do filme é obrigatório")
        Long filmeId,
        @Size(min = 2, max = 500, message = "A análise deve ter entre 2 e 500 caracteres")
        String filmeAnalise,
        @NotNull(message = "Nota obrigatória")
        @Min(0)
        @Max(5)
        Integer nota
        ) {

}
