package com.senac.uc14.atv4.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.uc14.atv4.model.dto.AnaliseDTO;
import com.senac.uc14.atv4.model.entity.Analise;
import com.senac.uc14.atv4.service.AnaliseService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/analises")
public class AnaliseController {

    private final AnaliseService analiseService;

    public AnaliseController(AnaliseService analiseService) {
        this.analiseService = analiseService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Analise> cadastrarAnalise(@Valid @RequestBody AnaliseDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(analiseService.analiseRegister(dto));
    }

    @GetMapping
    public ResponseEntity<List<Analise>> listarAnalises() {
        return ResponseEntity.status(HttpStatus.OK).body(analiseService.analiseListAll());
    }

}
