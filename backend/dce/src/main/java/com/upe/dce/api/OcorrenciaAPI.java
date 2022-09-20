package com.upe.dce.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaServiceImpl;

@RequestMapping("/api")
@RestController
public class OcorrenciaAPI {

	@Autowired
	private OcorrenciaServiceImpl ocorrenciaServico;

	@GetMapping("/ocorrencias")
	public ResponseEntity<List<Ocorrencia>> listarOcorrencias() {
		return ResponseEntity.ok(ocorrenciaServico.listarOcorrencias());
	}

	@GetMapping("/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> buscarOcorrenciaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(ocorrenciaServico.buscarPorIdOcorrencia(id));
	}

	@PostMapping("/ocorrencia")
	public ResponseEntity<Ocorrencia> incluirOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());

		Ocorrencia novaOcorrencia = ocorrenciaServico.incluirOcorrencia(ocorrencia);

		return ResponseEntity.created(uri).body(novaOcorrencia);
	}

	@PutMapping("/ocorrencia")
	public ResponseEntity<Ocorrencia> alterarOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());

		Ocorrencia ocorrenciaAlterada = ocorrenciaServico.alterarOcorrencia(ocorrencia);

		return ResponseEntity.created(uri).body(ocorrenciaAlterada);
	}

	@DeleteMapping("ocorrencia/{id}")
	public void excluirOcorrencia(@PathVariable Long id) {
		ocorrenciaServico.excluirOcorrencia(id);
	}
}
