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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.upe.dce.api.dtos.DTOConverter;
import com.upe.dce.api.dtos.UsuarioDTO;
import com.upe.dce.core.usuario.Usuario;
import com.upe.dce.core.usuario.UsuarioServiceImpl;

@RequestMapping("/api")
@RestController
public class UsuarioAPI {

	@Autowired
	private UsuarioServiceImpl servicoUsuario;

	@Autowired
	private DTOConverter conversor;

	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
		return ResponseEntity.ok(servicoUsuario.listarUsuarios().stream()
				.map(entidade -> conversor.convertToDTO(entidade)).collect(Collectors.toList()));
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorIdUsuario(@PathVariable Long id) {
		UsuarioDTO resultado = conversor.convertToDTO(servicoUsuario.buscarPorIdUsuario(id));
		return ResponseEntity.ok().body(resultado);
	}

	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDTO> incluirUsuario(@RequestBody UsuarioDTO dto) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/usuario").toUriString());
		
		Usuario usuario = conversor.convertToEntity(dto);
		UsuarioDTO resultado = conversor.convertToDTO(servicoUsuario.incluirUsuario(usuario));
		
		return ResponseEntity.created(uri).body(resultado);
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> alterarUsuario(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/usuario").toUriString());
		
		Usuario usuario = conversor.convertToEntity(dto);
		usuario.setId(id);
		
		UsuarioDTO resultado = conversor.convertToDTO(servicoUsuario.alterarUsuario(usuario));
		
		return ResponseEntity.created(uri).body(resultado);
	}

	@DeleteMapping("/usuario/{id}")
	public void excluirUsuario(@PathVariable Long id) {
		servicoUsuario.excluirUsuario(id);
	}
}
