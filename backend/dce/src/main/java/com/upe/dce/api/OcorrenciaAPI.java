package com.upe.dce.api;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaServiceImpl;

@RequestMapping("/api")
@RestController
public class OcorrenciaAPI {
	
	@Autowired
	private OcorrenciaServiceImpl ocorrenciaServico;
	
	@PostMapping("/ocorrencia")
	public ResponseEntity<Ocorrencia> incluirOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());
		
		Ocorrencia novaOcorrencia = ocorrenciaServico.incluirOcorrencia(ocorrencia);
	
		return ResponseEntity.created(uri).body(novaOcorrencia);
	}
}
