package com.upe.dce.api.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.upe.dce.core.ocorrencia.TipoOcorrenciaEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoOcorrenciaDTO {
	private Long id;
	@Enumerated(EnumType.STRING)
	private TipoOcorrenciaEnum tipoOcorrencia;
}
