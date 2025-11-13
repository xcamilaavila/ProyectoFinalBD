package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.InscripcionModel;

public interface IInscripcionService {
    
    public InscripcionModel guardarInscripcion(InscripcionModel inscripcion);
    public List <InscripcionModel> listarInscripciones();
    public InscripcionModel buscarInscripcionPorId(Integer id);
    public String cancelarInscripcion (Integer id);
    public InscripcionModel actualizarInscripcion (Integer id, InscripcionModel inscripcion);

}
