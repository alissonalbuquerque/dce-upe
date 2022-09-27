package com.upe.dce.api.dtos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaRepository;
import com.upe.dce.core.ocorrencia.OcorrenciaUsuario;
import com.upe.dce.core.ocorrencia.TipoOcorrencia;
import com.upe.dce.core.usuario.Endereco;
import com.upe.dce.core.usuario.TipoUsuario;
import com.upe.dce.core.usuario.Usuario;
import com.upe.dce.core.usuario.UsuarioRepository;

public class DTOConverter {
	@Autowired
	OcorrenciaRepository ocorrenciaRepositorio;

	@Autowired
	UsuarioRepository usuarioRepositorio;

	public OcorrenciaDTO convertToDTO(Ocorrencia ocorrencia) {
		//TODO
		return null;
	}

	public Ocorrencia convertToEntity(OcorrenciaDTO dto) {
		//TODO
		return null;
	}

	public TipoOcorrenciaDTO convertToDTO(TipoOcorrencia tipoOcorrencia) {
		TipoOcorrenciaDTO resultado = TipoOcorrenciaDTO.builder().id(tipoOcorrencia.getId())
				.tipoOcorrencia(tipoOcorrencia.getTipoOcorrenciaEnum()).build();

		return resultado;
	}

	public TipoOcorrencia convertToEntity(TipoOcorrenciaDTO dto) {
		TipoOcorrencia resultado = TipoOcorrencia.builder().id(dto.getId()).tipoOcorrenciaEnum(dto.getTipoOcorrencia())
				.build();

		return resultado;
	}

	public OcorrenciaUsuarioDTO convertToDTO(OcorrenciaUsuario ocorrenciaUsuario) {
		OcorrenciaUsuarioDTO resultado = OcorrenciaUsuarioDTO.builder()
				.idOcorrencia(ocorrenciaUsuario.getOcorrencia().getId())
				.idUsuario(ocorrenciaUsuario.getUsuario().getId()).perfilUsuario(ocorrenciaUsuario.getPerfilUsuario())
				.build();
		
		return resultado;
	}

	public OcorrenciaUsuario convertToEntity(OcorrenciaUsuarioDTO dto) {
		Ocorrencia ocorrencia = ocorrenciaRepositorio.findById(dto.getIdOcorrencia()).get();
		Usuario usuario = usuarioRepositorio.findById(dto.getIdUsuario()).get();

		OcorrenciaUsuario resultado = OcorrenciaUsuario.builder().perfilUsuario(dto.getPerfilUsuario())
				.ocorrencia(ocorrencia).usuario(usuario).build();

		return resultado;
	}

	public UsuarioDTO convertToDTO(Usuario usuario) {
		UsuarioDTO resultado = UsuarioDTO.builder().nome(usuario.getNome()).cpf(usuario.getCpf()).build();

		if (usuario.getEnderecos() != null && !usuario.getEnderecos().isEmpty()) {
			resultado.setEnderecos(new ArrayList<EnderecoDTO>());

			usuario.getEnderecos().stream().forEach(endereco -> resultado.getEnderecos().add(convertToDTO(endereco)));
		}

		//TODO
		// convert ocorrenciaUsuario
		// convert perfis

		return resultado;
	}

	public Usuario convertToEntity(UsuarioDTO dto) {
		//TODO
		return null;
	}

	public TipoUsuarioDTO convertToDTO(TipoUsuario tipoUsuario) {
		TipoUsuarioDTO resultado = TipoUsuarioDTO.builder().id(tipoUsuario.getId())
				.permissao(tipoUsuario.getPermissao()).build();

		return resultado;
	}

	public TipoUsuario convertToEntity(TipoUsuarioDTO dto) {
		TipoUsuario resultado = TipoUsuario.builder().id(dto.getId()).permissao(dto.getPermissao()).build();

		return resultado;
	}

	public EnderecoDTO convertToDTO(Endereco endereco) {
		EnderecoDTO resultado = EnderecoDTO.builder().id(endereco.getId()).cep(endereco.getCep())
				.logradouro(endereco.getLogradouro()).complemento(endereco.getComplemento())
				.bairro(endereco.getBairro()).cidade(endereco.getCidade()).uf(endereco.getUf()).build();

		return resultado;
	}

	public Endereco convertToEntity(EnderecoDTO dto) {
		Endereco resultado = Endereco.builder().id(dto.getId()).cep(dto.getCep()).logradouro(dto.getLogradouro())
				.complemento(dto.getComplemento()).bairro(dto.getBairro()).cidade(dto.getCidade()).uf(dto.getUf())
				.build();

		return resultado;
	}

}
