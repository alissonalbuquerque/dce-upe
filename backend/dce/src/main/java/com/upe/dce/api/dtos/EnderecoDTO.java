package com.upe.dce.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO {
	private Long id;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
}
