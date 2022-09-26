package com.upe.dce.core.usuario;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.upe.dce.utilities.Entidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "Endereco")
@Table(name = "endereco")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends Entidade {
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
}
