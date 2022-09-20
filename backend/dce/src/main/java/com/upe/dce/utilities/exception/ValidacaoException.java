package com.upe.dce.utilities.exception;

import java.util.List;

import com.upe.dce.utilities.validation.DetalheErro;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidacaoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	private List<DetalheErro> detalhes;
	
	public ValidacaoException(String mensagem) {
		super(mensagem);
	}
	
	public ValidacaoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	@Builder
	public ValidacaoException(String mensagem, List<DetalheErro> detalhes, Throwable causa) {
		super(mensagem, causa);
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}
	
}
