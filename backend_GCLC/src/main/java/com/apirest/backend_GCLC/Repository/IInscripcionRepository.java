package com.apirest.backend_GCLC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend_GCLC.Model.InscripcionModel;

public interface IInscripcionRepository extends JpaRepository<InscripcionModel, Integer>{
    boolean existsByReto_IdReto(Integer idReto);
    
}
