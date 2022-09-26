package com.upe.dce.core.ocorrencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upe.dce.utilities.exception.DceException;
import com.upe.dce.utilities.validation.ValidacaoUtil;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	OcorrenciaRepository ocorrenciaRepositorio;

	@Override
	public List<Ocorrencia> listarOcorrencias() {
		return ocorrenciaRepositorio.findAll();
	}

	@Override
	public Ocorrencia buscarPorIdOcorrencia(Long id) {
		if (!ocorrenciaRepositorio.findById(id).isPresent()) {
			throw new DceException("Informe um identificador válido para a ocorrencia alterada");
		}
		
		return ocorrenciaRepositorio.findById(id).get();
	}

	@Override
	public Ocorrencia incluirOcorrencia(Ocorrencia ocorrencia) {
		ValidacaoUtil.validar(ocorrencia);
		return ocorrenciaRepositorio.save(ocorrencia);
	}

	@Override
	public Ocorrencia alterarOcorrencia(Ocorrencia ocorrencia) {
		ValidacaoUtil.validar(ocorrencia);
		
		if (!ocorrenciaRepositorio.findById(ocorrencia.getId()).isPresent()) {
			throw new DceException("Informe um identificador válido para a ocorrencia alterada");
		}
		
		Ocorrencia ocorrenciaExistente = ocorrenciaRepositorio.findById(ocorrencia.getId()).get();
		
		if (ocorrencia.getTiposOcorrencia() == null) {
			ocorrencia.setTiposOcorrencia(ocorrenciaExistente.getTiposOcorrencia());
		}
		
		return ocorrenciaRepositorio.save(ocorrencia);
		
	}

	@Override
	public void excluirOcorrencia(Long id) {
		if (!ocorrenciaRepositorio.findById(id).isPresent()) {
			throw new DceException("Informe um identificador válido para a ocorrencia a ser apagada");
		}
		
		ocorrenciaRepositorio.delete(ocorrenciaRepositorio.findById(id).get());
	}

}
