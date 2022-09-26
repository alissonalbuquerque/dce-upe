package com.upe.dce.api.dtos;

import com.upe.dce.core.ocorrencia.PerfilEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OcorrenciaUsuarioDTO {
	private Long id;
	private UsuarioDTO usuario;
	private PerfilEnum perfilUsuario;
}
