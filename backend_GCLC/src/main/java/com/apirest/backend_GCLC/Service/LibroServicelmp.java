package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Model.LibroModel;
import com.apirest.backend_GCLC.Repository.ILibroRepository;
@Service

public class LibroServicelmp implements ILibroService{

    @Autowired ILibroRepository iLibroRepository;
    @Override
    public LibroModel guardaLibro(LibroModel libro) {
        return iLibroRepository.save(libro);
    }

    @Override
    public List<LibroModel> listaLibro() {
        return iLibroRepository.findAll();
    }
    
}
