package com.senac.uc14.atv2.model.dto;

import com.senac.uc14.atv2.model.entity.Filme;

public record AnaliseDTO(Filme filme, String filmeAnalise, Integer nota) {
}