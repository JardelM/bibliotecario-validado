package com.compass.biblioteca.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.compass.biblioteca.entity.Bibliotecario;
import com.compass.biblioteca.entity.dto.BibliotecarioDto;
import com.compass.biblioteca.entity.dto.BibliotecarioFormDto;
import com.compass.biblioteca.entity.dto.MessageResponseDto;
import com.compass.biblioteca.exceptions.ResourceNotFoudException;
import com.compass.biblioteca.repository.BibliotecarioRepository;

@Service
public class BibliotecarioServiceImple implements BibliotecarioService {

	@Autowired
	private BibliotecarioRepository bibliotecarioRepository;

	@Autowired
	private ModelMapper modelMapper;

	// funcionando
	@Override
	public List<BibliotecarioDto> buscarTodos() {

		List<Bibliotecario> bibliotecarios = this.bibliotecarioRepository.findAll();

		return bibliotecarios.stream().map(bibliotecario -> modelMapper.map(bibliotecario, BibliotecarioDto.class))
				.collect(Collectors.toList());

	}

	// funcionando
	@Override
	public BibliotecarioDto buscarId(Long id) {

		Bibliotecario bibliotecario = this.bibliotecarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoudException(id));

		return modelMapper.map(bibliotecario, BibliotecarioDto.class);
	}

	// funcionando
	@Override
	public void deletar(Long id) {
		this.bibliotecarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoudException(id));
		this.bibliotecarioRepository.flush();
		this.bibliotecarioRepository.deleteById(id);
	}

	@Override
	public MessageResponseDto criar(BibliotecarioFormDto bibliotecarioFormDto) {

		Bibliotecario bibliotecarioASalvar = modelMapper.map(bibliotecarioFormDto, Bibliotecario.class);
		Bibliotecario billiotecarioSalvo = this.bibliotecarioRepository.save(bibliotecarioASalvar);

		return MessageResponseDto.builder()
				.message(String.format("Criado Bibliotecario de id %s", billiotecarioSalvo.getId())).build();

	}

	@Override
	public MessageResponseDto atualizar(Long id, BibliotecarioFormDto bibliotecarioFormDto) {

		this.bibliotecarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoudException(id));

		Bibliotecario bibliotecarioParaAtualizar = modelMapper.map(bibliotecarioFormDto, Bibliotecario.class);

		bibliotecarioParaAtualizar.setId(id);
		this.bibliotecarioRepository.save(bibliotecarioParaAtualizar);

		return MessageResponseDto.builder()
				.message(String.format("Bibliotecario de id %s atualizado!", bibliotecarioParaAtualizar.getId()))
				.build();
	}

}
