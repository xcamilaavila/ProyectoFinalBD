package com.apirest.backend_GCLC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend_GCLC.Model.AsociacionId;
import com.apirest.backend_GCLC.Model.AsociacionModel;

public interface IAsociacionRepository extends JpaRepository<AsociacionModel, AsociacionId> {
    boolean existsByIdIdLibroAndIdIdReto(Integer idLibro, Integer idReto);
}
