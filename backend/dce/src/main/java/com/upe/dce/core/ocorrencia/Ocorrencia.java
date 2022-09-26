package com.upe.dce.core.ocorrencia;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.upe.dce.core.usuario.Usuario;
import com.upe.dce.utilities.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Entity(name = "ocorrencia")
@Table(name = "ocorrencia")
@Data
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Ocorrencia extends Entidade {
	@NotBlank(message = "O título é obrigatório")
	@Size(message = "O título deve estar entre 5 e 200 caracteres", min = 5, max = 200)
	@Column(
			name = "titulo",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String titulo;
	
	@NotBlank(message = "A descrição é obrigatória")
	@Size(message = "A descrição deve estar entre 20 e 200 caracteres", min = 20, max = 200)
	@Column(
			name = "descricao",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String descricao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, targetEntity = TipoOcorrencia.class)
	private List<TipoOcorrencia> tiposOcorrencia;
	
	@OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL)
	private List<OcorrenciaUsuario> ocorrenciasUsuarios;
}
