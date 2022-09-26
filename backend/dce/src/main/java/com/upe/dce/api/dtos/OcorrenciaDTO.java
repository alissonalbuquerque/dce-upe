package com.upe.dce.api.dtos;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OcorrenciaDTO {
	private Long id;
	private String titulo;
	private String descricao;
	private List<TipoOcorrenciaDTO> tiposOcorrencias;
	private List<OcorrenciaUsuarioDTO> usuarios;
}
