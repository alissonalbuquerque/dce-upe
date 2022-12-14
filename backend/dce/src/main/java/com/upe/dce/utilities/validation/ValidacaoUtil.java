package com.upe.dce.utilities.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.upe.dce.utilities.Entidade;
import com.upe.dce.utilities.exception.ValidacaoException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ValidacaoUtil {
	private ValidacaoUtil() {}
	
	private static Validator validator;
	
	@Autowired
	public void setValidator(Validator validator) {
		ValidacaoUtil.validator = validator;
	}
	
	public static final void valida(String string, String mensagem) {
		if (!StringUtils.hasText(string)) {
			log.error(mensagem);
			ValidacaoException.builder().mensagem(mensagem).build();
		}
	}
	
	public static final void valida(String mensagem, String... campos) {
		if (campos == null) {
			log.error(mensagem);
			throw ValidacaoException.builder().mensagem(mensagem).build();
		}

		List<DetalheErro> violacoes = Stream.of(campos).filter(campo -> !StringUtils.hasText(campo))
				.map(violacao -> DetalheErro.builder().descricao(violacao).build()).collect(Collectors.toList());

		if (!violacoes.isEmpty()) {
			log.error("Os campos estão com preenchimento inválido {}", violacoes);

			throw ValidacaoException.builder().mensagem(mensagem).detalhes(violacoes).build();
		}
	}
	
	public static final void validar(Entidade entidade) {
		log.debug("Iniciando validação de entidade");

		if (entidade == null) {
			log.error("A entidade não foi preenchida");
			throw ValidacaoException.builder().mensagem("Campos obrigatórios não preechidos ").build();
		}

		List<DetalheErro> violacoes = validator.validate(entidade).stream()
				.map(violacao -> DetalheErro.builder().descricao(violacao.getMessage()).build())
				.collect(Collectors.toList());

		if (!violacoes.isEmpty()) {
			log.error("A entidade está com preenchimento inválido {}", violacoes);

			throw ValidacaoException.builder()
					.mensagem("Ocorreu um erro ao validar " + entidade.getClass().getSimpleName()).detalhes(violacoes)
					.build();
		}
	}
}
