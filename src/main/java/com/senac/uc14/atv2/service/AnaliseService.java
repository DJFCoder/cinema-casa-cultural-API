package com.senac.uc14.atv2.service;

import org.springframework.stereotype.Service;

import com.senac.uc14.atv2.model.dto.AnaliseDTO;
import com.senac.uc14.atv2.model.entity.Analise;
import com.senac.uc14.atv2.model.entity.Filme;
import com.senac.uc14.atv2.repository.AnaliseRepository;
import com.senac.uc14.atv2.repository.FilmeRepository;

import jakarta.validation.Valid;

@Service
public class AnaliseService {

    private final AnaliseRepository analiseRepository;
    private final FilmeRepository filmeRepository;

    public AnaliseService(AnaliseRepository analiseRepository, FilmeRepository filmeRepository) {
        this.analiseRepository = analiseRepository;
        this.filmeRepository = filmeRepository;
    }

    public Analise analiseRegister(@Valid AnaliseDTO dto) {
        // Buscar o filme pelo ID
        Filme filme = filmeRepository.findById(dto.filmeId())
                .orElseThrow(
                        () -> new RuntimeException("Filme não encontrado com ID: " + dto.filmeId())
                );
        // Montar a análise
        Analise entity = new Analise();
        entity.setFilme(filme);
        entity.setFilmeAnalise(dto.filmeAnalise());
        entity.setNota(dto.nota());

        return analiseRepository.save(entity);
    }
}
