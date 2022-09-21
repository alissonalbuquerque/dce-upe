package com.upe.dce.core.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.br.CPF;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.utilities.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Entidade {
	@NotBlank(message = "O nome é obrigatório")
	@Size(message = "O nome deve estar entre 4 e 50 caracteres", min = 4, max = 50)
	private String nome;

	@CPF
	private String cpf;

	private String endereco;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, targetEntity = Ocorrencia.class)
	private List<Ocorrencia> ocorrencias;
}
