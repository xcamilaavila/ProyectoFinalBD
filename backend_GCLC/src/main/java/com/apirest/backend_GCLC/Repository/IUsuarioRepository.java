package com.apirest.backend_GCLC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend_GCLC.Model.UsuarioModel;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
    /// Aqui va a ir todas las consultas nativas
    
}
