package com.apirest.backend_GCLC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend_GCLC.Model.LibroModel;

public interface ILibroRepository extends JpaRepository<LibroModel, Integer>{
    
}
