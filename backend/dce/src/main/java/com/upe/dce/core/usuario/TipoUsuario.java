package com.upe.dce.core.usuario;

import com.upe.dce.core.ocorrencia.PerfilEnum;
import com.upe.dce.utilities.Entidade;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class TipoUsuario extends Entidade {

  @Id
  @GeneratedValue
  private Long id;

  private PerfilEnum permissao;
}

