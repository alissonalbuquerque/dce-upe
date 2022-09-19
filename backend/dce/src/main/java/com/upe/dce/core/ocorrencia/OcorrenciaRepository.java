package com.upe.dce.core.ocorrencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
	Optional<Ocorrencia> findById(Long id);
}
