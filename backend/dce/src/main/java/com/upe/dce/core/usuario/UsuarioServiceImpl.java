package com.upe.dce.core.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upe.dce.utilities.exception.DceException;
import com.upe.dce.utilities.validation.ValidacaoUtil;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepositorio;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Usuario buscarPorIdUsuario(Long id) {
		if (!usuarioRepositorio.findById(id).isPresent()) {
			throw new DceException("Informe um identificador válido para a ocorrencia alterada");
		}
		
		return usuarioRepositorio.findById(id).get();
	}

	@Override
	public Usuario incluirUsuario(Usuario usuario) {
		ValidacaoUtil.validar(usuario);
		
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public Usuario alterarUsuario(Usuario usuario) {
		ValidacaoUtil.validar(usuario);
		
		if (!usuarioRepositorio.findById(usuario.getId()).isPresent()) {
			throw new DceException("Informe um identificador válido para o usuário alterada");
		}
		
		Usuario usuarioExistente = usuarioRepositorio.findById(usuario.getId()).get();
		usuario.setOcorrenciasUsuarios(usuarioExistente.getOcorrenciasUsuarios());
		
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public void excluirUsuario(Long id) {
		if (!usuarioRepositorio.findById(id).isPresent()) {
			throw new DceException("Informe um identificador válido para o usuário a ser apagado");
		}
		
		usuarioRepositorio.delete(usuarioRepositorio.findById(id).get());
	}

}
