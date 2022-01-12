package com.compass.biblioteca.entity.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecarioFormDto {

	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
}
