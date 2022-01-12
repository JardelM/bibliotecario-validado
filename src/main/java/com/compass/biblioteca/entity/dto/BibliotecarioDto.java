package com.compass.biblioteca.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecarioDto {

	private Long Id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;

}
