package com.compass.biblioteca.exceptions;

public class ResourceNotFoudException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoudException(Long id) {
		super(String.format("Id %s não encontrado no cadastro",id));
	}


}
