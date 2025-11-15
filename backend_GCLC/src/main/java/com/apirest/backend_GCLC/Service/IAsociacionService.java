package com.apirest.backend_GCLC.Service;

import com.apirest.backend_GCLC.DTO.AsociacionDTO;
import com.apirest.backend_GCLC.Model.AsociacionModel;

public interface IAsociacionService {
    
     AsociacionModel crearAsociacion(AsociacionDTO dto);
}
