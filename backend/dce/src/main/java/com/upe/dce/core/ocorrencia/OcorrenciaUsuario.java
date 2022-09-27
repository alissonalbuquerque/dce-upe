package com.upe.dce.core.ocorrencia;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.upe.dce.core.usuario.Usuario;

import lombok.Builder;
import lombok.Data;

@Entity(name = "OcorrenciaUsuario")
@Table(name = "ocorrencia_usuario")
@Data
@Builder
public class OcorrenciaUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ocorrencia")
	private Ocorrencia ocorrencia;
    
    @Enumerated(EnumType.STRING)
    private PerfilEnum perfilUsuario;
}
