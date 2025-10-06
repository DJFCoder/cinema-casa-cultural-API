package com.senac.uc14.atv4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.uc14.atv4.model.entity.Analise;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {
}
