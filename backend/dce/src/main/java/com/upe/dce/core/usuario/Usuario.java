package com.upe.dce.core.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.br.CPF;

import com.upe.dce.core.ocorrencia.Ocorrencia;
import com.upe.dce.core.ocorrencia.OcorrenciaUsuario;
import com.upe.dce.utilities.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Entity(name = "Usuario")
@Table(
	name = "usuario",
	uniqueConstraints = {
			@UniqueConstraint(name = "usuario_cpf_unique", columnNames = "cpf")
	}
)
@Data
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Entidade {
	@NotBlank(message = "O nome é obrigatório")
	@Size(message = "O nome deve estar entre 4 e 50 caracteres", min = 4, max = 50)
	@Column(
			name = "nome",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String nome;

	@CPF
	@Column(
			name = "cpf",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String cpf;

	@Column(
			name = "endereco",
			nullable = true,
			columnDefinition = "TEXT"
	)
	private String endereco;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<OcorrenciaUsuario> ocorrenciasUsuarios;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<TipoUsuario> tipoUsuario = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Endereco> enderecos;
}
