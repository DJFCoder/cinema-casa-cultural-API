package com.senac.uc14.atv2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senac.uc14.atv2.model.dto.AnaliseDTO;
import com.senac.uc14.atv2.model.entity.Analise;
import com.senac.uc14.atv2.model.entity.Filme;
import com.senac.uc14.atv2.repository.AnaliseRepository;

@Service
public class AnaliseService {

    private final AnaliseRepository analiseRepository;
    private final FilmeService filmeService;

    public AnaliseService(AnaliseRepository analiseRepository, FilmeService filmeService) {
        this.analiseRepository = analiseRepository;
        this.filmeService = filmeService;
    }

    public Analise analiseRegister(AnaliseDTO dto) {
        // Busca o filme pelo ID
        Filme filme = filmeService.getFilmeById(dto.filmeId());
        // Monta a análise referente ao filme indicado
        Analise entity = new Analise();
        entity.setFilme(filme);
        entity.setFilmeAnalise(dto.filmeAnalise());
        entity.setNota(dto.nota());

        return analiseRepository.save(entity);
    }

    public List<Analise> analiseListAll() {
        return analiseRepository.findAll();
    }
}
