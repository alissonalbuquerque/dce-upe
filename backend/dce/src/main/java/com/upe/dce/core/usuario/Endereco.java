package com.upe.dce.core.usuario;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Endereco")
@Table(name = "endereco")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
}
