package com.senac.uc14.atv4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senac.uc14.atv4.model.dto.FilmeDTO;
import com.senac.uc14.atv4.model.entity.Filme;
import com.senac.uc14.atv4.repository.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public Filme filmeRegister(FilmeDTO dto) {
        Filme entity = new Filme();
        entity.setTitulo(dto.titulo());
        entity.setSinopse(dto.sinopse());
        entity.setGenero(dto.genero());
        entity.setAnoLancamento(dto.anoLancamento());

        return repository.save(entity);
    }

    public List<Filme> filmesListAll() {
        return repository.findAll();
    }

    public Filme getFilmeById(Long filmeId) {
        return repository.findById(filmeId).orElseThrow(
                () -> new RuntimeException("Filme não encontrado com ID: " + filmeId)
        );
    }
}
