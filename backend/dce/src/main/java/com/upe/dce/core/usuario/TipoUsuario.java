package com.upe.dce.core.usuario;

import com.upe.dce.core.ocorrencia.OcorrenciaUsuario;
import com.upe.dce.core.ocorrencia.PerfilEnum;
import com.upe.dce.utilities.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity(name = "TipoUsuario")
@Table(name = "tipo_usuario")
@Data
@SuperBuilder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoUsuario extends Entidade {
	@Enumerated(EnumType.STRING)
	private PerfilEnum permissao;
}
