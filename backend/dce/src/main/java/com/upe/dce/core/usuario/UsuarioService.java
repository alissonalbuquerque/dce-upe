package com.upe.dce.core.usuario;

import java.util.List;

public interface UsuarioService {
	List<Usuario> listarUsuarios();
	
	Usuario buscarPorIdUsuario(Long id);
	
	Usuario incluirUsuario(Usuario usuario);
	
	Usuario alterarUsuario(Usuario usuario);
	
	void excluirUsuario(Long id);
}
