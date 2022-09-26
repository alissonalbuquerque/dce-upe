package com.upe.dce.api.dtos;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaUsuario;
import com.upe.dce.core.ocorrencia.TipoOcorrencia;
import com.upe.dce.core.ocorrencia.TipoOcorrenciaEnum;
import com.upe.dce.core.usuario.Endereco;
import com.upe.dce.core.usuario.TipoUsuario;
import com.upe.dce.core.usuario.Usuario;

public class DTOConverter {
	public OcorrenciaDTO convertToDTO(Ocorrencia ocorrencia) {
		return null;
	}

	public Ocorrencia convertToEntity(OcorrenciaDTO dto) {
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
		return null;
	}

	public OcorrenciaUsuario convertToEntity(OcorrenciaUsuarioDTO dto) {
		return null;
	}

	public UsuarioDTO convertToDTO(Usuario usuario) {
		return null;
	}

	public Usuario convertToEntity(UsuarioDTO dto) {
		return null;
	}

	public TipoUsuarioDTO convertToDTO(TipoUsuario tipoUsuario) {
		return null;
	}

	public TipoUsuario convertToEntity(TipoUsuarioDTO dto) {
		return null;
	}

	public EnderecoDTO convertToDTO(Endereco endereco) {
		return null;
	}

	public Endereco convertToEntity(EnderecoDTO dto) {
		return null;
	}

}
