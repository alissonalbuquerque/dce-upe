package com.upe.dce.core.ocorrencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	OcorrenciaRepository ocorrenciaRepositorio;

	@Override
	public List<Ocorrencia> listarOcorrencias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ocorrencia buscarPorIdOcorrencia(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ocorrencia incluirOcorrencia(Ocorrencia ocorrencia) {
		return ocorrenciaRepositorio.save(ocorrencia);
	}

	@Override
	public Ocorrencia alterarOcorrencia(Ocorrencia ocorrencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirOcorrencia(Long id) {
		// TODO Auto-generated method stub

	}

}
