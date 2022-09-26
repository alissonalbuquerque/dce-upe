package com.upe.dce.api;

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
import org.springframework.web.bind.annotation.RestController;

import com.upe.dce.core.usuario.Usuario;
import com.upe.dce.core.usuario.UsuarioServiceImpl;

@RequestMapping("/api")
@RestController
public class UsuarioAPI {

	@Autowired
	private UsuarioServiceImpl servicoUsuario;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(servicoUsuario.listarUsuarios());
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> buscarPorIdUsuario(@PathVariable Long id) {
		return ResponseEntity.ok(servicoUsuario.buscarPorIdUsuario(id));
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(servicoUsuario.incluirUsuario(usuario));
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		usuario.setId(id);
		return ResponseEntity.ok(servicoUsuario.incluirUsuario(usuario));
	}
	
	@DeleteMapping("/usuario/{id}")
	public void excluirUsuario(@PathVariable Long id) {
		servicoUsuario.excluirUsuario(id);
	}
}
