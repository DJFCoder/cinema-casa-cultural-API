package com.senac.uc14.atv2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.uc14.atv2.model.dto.FilmeDTO;
import com.senac.uc14.atv2.model.entity.Filme;
import com.senac.uc14.atv2.service.FilmeService;

import jakarta.validation.Valid;

@RestController
// @CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Filme> cadastrarFilme(@Valid @RequestBody FilmeDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.filmeRegister(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Filme>> listarFilmesCadastrados() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.filmesListAll());
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Filme> mostrarDetalhesDoFilmePorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getFilmeById(id));
    }
}
