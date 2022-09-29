package com.upe.dce.core.ocorrencia;

import java.util.List;

public interface OcorrenciaService {
	List<Ocorrencia> listarOcorrencias();

	Ocorrencia buscarPorIdOcorrencia(Long id);

	Ocorrencia incluirOcorrencia(Ocorrencia ocorrencia);

	Ocorrencia alterarOcorrencia(Ocorrencia ocorrencia);
	
	Ocorrencia associarUsuarioOcorrencia(Long idOcorrencia, Long idUsuario, PerfilEnum perfil);

	void excluirOcorrencia(Long id);
}
