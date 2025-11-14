package com.apirest.backend_GCLC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend_GCLC.Model.ProgresoRetoModel;

public interface IProgresoRetoRepository extends JpaRepository <ProgresoRetoModel, Integer> {
    
}
