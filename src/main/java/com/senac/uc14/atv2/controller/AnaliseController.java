package com.senac.uc14.atv2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/analises")
public class AnaliseController {

  @PostMapping
  public ResponseEntity<Object> salvarAnalise() {
    return null;
  }

}