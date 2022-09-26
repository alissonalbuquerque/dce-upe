package com.upe.dce.api.dtos;

import com.upe.dce.core.ocorrencia.TipoOcorrenciaEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoOcorrenciaDTO {
	private Long id;
	private TipoOcorrenciaEnum tipoOcorrencia;
}
