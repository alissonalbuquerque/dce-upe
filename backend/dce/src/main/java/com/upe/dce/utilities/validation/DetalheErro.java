package com.upe.dce.utilities.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DetalheErro {
	private String descricao;
}
