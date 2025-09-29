package com.senac.uc14.atv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

  @PostMapping
  public ResponseEntity<Object> cadastrarFilme() {
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> atualizarFilme(@PathVariable Long id) {
    return null;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletarFilme(@PathVariable Long id) {
    return null;
  }
}