package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.DTO.ProgresoRetoDTO;
import com.apirest.backend_GCLC.Model.ProgresoRetoModel;

public interface IProgresoRetoService {
    public ProgresoRetoModel guardarProgresoReto(ProgresoRetoDTO progreso);
    public List <ProgresoRetoModel >listarProgresos ();
    public ProgresoRetoModel buscarProgresoPorId (Integer id);
    public ProgresoRetoModel actualizarProgreso (Integer id, ProgresoRetoModel progreso);
    public String eliminarProgreso (Integer id);
}
