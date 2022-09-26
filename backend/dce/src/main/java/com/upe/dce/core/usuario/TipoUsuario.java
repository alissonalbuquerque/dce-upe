package com.upe.dce.core.usuario;

import com.upe.dce.core.ocorrencia.PerfilEnum;
import com.upe.dce.utilities.Entidade;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class TipoUsuario extends Entidade {

  private PerfilEnum permissao;
}

