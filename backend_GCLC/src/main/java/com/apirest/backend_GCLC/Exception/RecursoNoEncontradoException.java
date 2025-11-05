package com.apirest.backend_GCLC.Exception;

public class RecursoNoEncontradoException extends RuntimeException {
	public RecursoNoEncontradoException(String mensaje){
		super(mensaje);
	}
}