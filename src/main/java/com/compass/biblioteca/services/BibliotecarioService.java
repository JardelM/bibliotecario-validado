package com.compass.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.compass.biblioteca.entity.dto.BibliotecarioDto;
import com.compass.biblioteca.entity.dto.BibliotecarioFormDto;
import com.compass.biblioteca.entity.dto.MessageResponseDto;

@Service
public interface BibliotecarioService {

	MessageResponseDto criar(BibliotecarioFormDto bibliotecarioFormDto);
	
	MessageResponseDto atualizar(Long id, BibliotecarioFormDto bibliotecarioFormDto);

	BibliotecarioDto buscarId(Long id);

	List<BibliotecarioDto> buscarTodos();
	
	public void deletar(Long id);

}
