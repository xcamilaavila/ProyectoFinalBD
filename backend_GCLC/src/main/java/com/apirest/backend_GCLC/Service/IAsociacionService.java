package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.DTO.AsociacionDTO;
import com.apirest.backend_GCLC.Model.AsociacionModel;


public interface IAsociacionService {
    
     AsociacionModel crearAsociacion(AsociacionDTO dto);
     public List <AsociacionModel >listarAsociados ();
     public AsociacionModel buscarAsociacionPorId(Integer idLibro, Integer idReto);
     public String eliminarAsociacion(Integer idLibro, Integer idReto);
}
