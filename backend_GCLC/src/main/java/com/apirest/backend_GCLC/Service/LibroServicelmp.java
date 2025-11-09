package com.apirest.backend_GCLC.Service;

import java.util.List;
import java.util.Optional;

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
    public List<LibroModel> listarLibros() {
        return iLibroRepository.findAll();
    }

    @Override
public LibroModel buscarLibroPorId(Integer id) {
    Optional<LibroModel> libro = iLibroRepository.findById(id);
    return libro.orElse(null);
}

@Override
    public String eliminarLibro(Integer id) {
        if (iLibroRepository.existsById(id)) {
            iLibroRepository.deleteById(id);
            return "Libro eliminado con ID: " + id;
        } else {
            return "No se encontró el libro con ID: " + id;
        }
    }

    @Override
public LibroModel actualizarLibro(Integer id, LibroModel libro) {
    LibroModel libroExistente = iLibroRepository.findById(id).orElse(null);

    if (libroExistente != null) {
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setAutor(libro.getAutor());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setAno_publicacion(libro.getAno_publicacion());
        libroExistente.setSinopsis(libro.getSinopsis());
        return iLibroRepository.save(libroExistente);
    }

    return null;
}
}
