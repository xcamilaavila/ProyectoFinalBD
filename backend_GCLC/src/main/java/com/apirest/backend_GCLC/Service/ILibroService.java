package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.LibroModel;

public interface ILibroService {
    public LibroModel guardaLibro (LibroModel libro);
    public List <LibroModel> listaLibro();
    
}
