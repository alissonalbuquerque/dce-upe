package com.upe.dce.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.upe.dce.api.dtos.DTOConverter;
import com.upe.dce.api.dtos.OcorrenciaDTO;
import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaServiceImpl;
import com.upe.dce.core.ocorrencia.PerfilEnum;
import com.upe.dce.core.ocorrencia.TipoOcorrenciaEnum;

@RequestMapping("/api")
@RestController
public class OcorrenciaAPI {

	@Autowired
	private OcorrenciaServiceImpl ocorrenciaServico;

	@Autowired
	private DTOConverter conversor;

	@GetMapping("/ocorrencias")
	public ResponseEntity<List<OcorrenciaDTO>> listarOcorrencias() {
		return ResponseEntity.ok(ocorrenciaServico.listarOcorrencias().stream()
				.map(entidade -> conversor.convertToDTO(entidade)).collect(Collectors.toList()));
	}

	@GetMapping("/ocorrencia/{id}")
	public ResponseEntity<OcorrenciaDTO> buscarOcorrenciaPorId(@PathVariable Long id) {
		OcorrenciaDTO resultado = conversor.convertToDTO(ocorrenciaServico.buscarPorIdOcorrencia(id));
		return ResponseEntity.ok().body(resultado);
	}

	@PostMapping("/ocorrencia")
	public ResponseEntity<OcorrenciaDTO> incluirOcorrencia(@RequestBody OcorrenciaDTO dto) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());
		System.out.println("dto: " + dto.getTiposOcorrencias()); // Teste
		Ocorrencia ocorrencia = conversor.convertToEntity(dto);
		System.out.println("conversor.convertToEntity(dto): " + ocorrencia.getTiposOcorrencia());// Teste
		OcorrenciaDTO resultado = conversor.convertToDTO(ocorrenciaServico.incluirOcorrencia(ocorrencia));
		System.out.println("após incluir ocorrencia: " + resultado.getTiposOcorrencias());// Teste
		return ResponseEntity.created(uri).body(resultado);
	}

	@PutMapping("/ocorrencia/{idOcorrencia}/usuario/{idUsuario}/perfil/{idPerfil}")
	public ResponseEntity<OcorrenciaDTO> associarUsuarioOcorrencia(@PathVariable Long idOcorrencia,
			@PathVariable Long idUsuario, @PathVariable Integer idPerfil) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());

		
		Ocorrencia ocorrencia = ocorrenciaServico.associarUsuarioOcorrencia(idOcorrencia, idUsuario,
				idPerfil);
		
		OcorrenciaDTO resultado = conversor.convertToDTO(ocorrencia);
		
		return ResponseEntity.created(uri).body(resultado);
	}

	@PutMapping("/ocorrencia/{id}")
	public ResponseEntity<OcorrenciaDTO> alterarOcorrencia(@RequestBody OcorrenciaDTO dto, @PathVariable Long id) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/ocorrencia").toUriString());

		Ocorrencia ocorrencia = conversor.convertToEntity(dto);
		ocorrencia.setId(id);

		OcorrenciaDTO resultado = conversor.convertToDTO(ocorrenciaServico.alterarOcorrencia(ocorrencia));

		return ResponseEntity.created(uri).body(resultado);
	}

	@DeleteMapping("ocorrencia/{id}")
	public void excluirOcorrencia(@PathVariable Long id) {
		ocorrenciaServico.excluirOcorrencia(id);
	}
}
