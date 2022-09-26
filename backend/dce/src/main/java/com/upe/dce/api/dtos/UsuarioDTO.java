package com.upe.dce.api.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;
	private List<OcorrenciaUsuarioDTO> ocorrencias;
	private List<TipoUsuarioDTO> perfis;
}