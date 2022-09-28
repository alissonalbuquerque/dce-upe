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
		OcorrenciaDTO resultado = OcorrenciaDTO.builder().id(ocorrencia.getId()).titulo(ocorrencia.getTitulo())
				.descricao(ocorrencia.getDescricao()).build();

		if (ocorrencia.getTiposOcorrencia() != null && !ocorrencia.getTiposOcorrencia().isEmpty()) {
			resultado.setTiposOcorrencias(new ArrayList<TipoOcorrenciaDTO>());
			
			ocorrencia.getTiposOcorrencia().stream()
					.forEach(tipo -> resultado.getTiposOcorrencias().add(convertToDTO(tipo)));
		}
		
		if (ocorrencia.getOcorrenciasUsuarios() != null && !ocorrencia.getTiposOcorrencia().isEmpty()) {
			resultado.setUsuarios(new ArrayList<OcorrenciaUsuarioDTO>());

			ocorrencia.getOcorrenciasUsuarios().stream()
					.forEach(usuario -> resultado.getUsuarios().add(convertToDTO(usuario)));
		}

		return resultado;
	}

	public Ocorrencia convertToEntity(OcorrenciaDTO dto) {
		Ocorrencia resultado = Ocorrencia.builder().id(dto.getId()).titulo(dto.getTitulo())
				.descricao(dto.getDescricao()).build();

		if (dto.getTiposOcorrencias() != null && !dto.getTiposOcorrencias().isEmpty()) {
			resultado.setTiposOcorrencia(new ArrayList<TipoOcorrencia>());
			
			dto.getTiposOcorrencias().stream()
					.forEach(tipo -> resultado.getTiposOcorrencia().add(convertToEntity(tipo)));
		}
		
		if (dto.getUsuarios() != null && !dto.getTiposOcorrencias().isEmpty()) {
			resultado.setOcorrenciasUsuarios(new ArrayList<OcorrenciaUsuario>());

			dto.getUsuarios().stream()
					.forEach(usuario -> resultado.getOcorrenciasUsuarios().add(convertToEntity(usuario)));
		}

		return resultado;
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

		if (usuario.getOcorrenciasUsuarios() != null && !usuario.getOcorrenciasUsuarios().isEmpty()) {
			resultado.setOcorrencias(new ArrayList<OcorrenciaUsuarioDTO>());

			usuario.getOcorrenciasUsuarios().stream()
					.forEach(ocorrencia -> resultado.getOcorrencias().add(convertToDTO(ocorrencia)));
		}

		if (usuario.getTipoUsuario() != null && !usuario.getTipoUsuario().isEmpty()) {
			resultado.setPerfis(new ArrayList<TipoUsuarioDTO>());

			usuario.getTipoUsuario().stream().forEach(tipo -> resultado.getPerfis().add(convertToDTO(tipo)));
		}

		return resultado;
	}

	public Usuario convertToEntity(UsuarioDTO dto) {
		Usuario resultado = Usuario.builder().nome(dto.getNome()).cpf(dto.getCpf()).build();

		if (dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()) {
			resultado.setEnderecos(new ArrayList<Endereco>());

			dto.getEnderecos().stream().forEach(endereco -> resultado.getEnderecos().add(convertToEntity(endereco)));
		}

		if (dto.getOcorrencias() != null && !dto.getOcorrencias().isEmpty()) {
			resultado.setOcorrenciasUsuarios(new ArrayList<OcorrenciaUsuario>());

			dto.getOcorrencias().stream()
					.forEach(ocorrencia -> resultado.getOcorrenciasUsuarios().add(convertToEntity(ocorrencia)));
		}

		if (dto.getPerfis() != null && !dto.getPerfis().isEmpty()) {
			resultado.setTipoUsuario(new ArrayList<TipoUsuario>());

			dto.getPerfis().stream().forEach(tipo -> resultado.getTipoUsuario().add(convertToEntity(tipo)));
		}

		return resultado;
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
