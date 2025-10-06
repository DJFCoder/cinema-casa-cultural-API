package com.senac.uc14.atv4.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record FilmeDTO(
        @NotNull(message = "Titulo obrigatório")
        @Size(max = 150, message = "Título muito longo")
        String titulo,
        @NotBlank(message = "Sinópse obrigatória")
        @Size(min = 20, max = 255, message = "Sinopse: 20-255 caracteres")
        String sinopse,
        @NotBlank(message = "Gênero obrigatório")
        @Pattern(regexp = "^(Ação|Drama|Comédia|Terror|Ficção Científica|Romance|Aventura|Animação|Suspense|Documentário)(, (Ação|Drama|Comédia|Terror|Ficção Científica|Romance|Aventura|Animação|Suspense|Documentário))*$",
                flags = Pattern.Flag.CANON_EQ,
                message = "Gênero deve ser: Ação, Drama, Comédia, Terror, Ficção Científica, Romance, Aventura ou Animação. ATENÇÃO: Caso houver mais de 1 gênero, use valores separados por vírgula")
        String genero,
        @Min(value = 1888, message = "Ano inválido")
        @Max(value = 2030, message = "Ano inválido")
        Integer anoLancamento) {

}
