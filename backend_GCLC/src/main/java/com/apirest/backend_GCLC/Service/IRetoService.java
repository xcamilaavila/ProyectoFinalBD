package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.RetoModel;


public interface IRetoService {

    
    public RetoModel guardarReto(RetoModel reto);
    public List<RetoModel> listarRetos();
    public RetoModel buscarRetoPorId(Integer id);
    public RetoModel actualizarReto(Integer id, RetoModel reto);
    public String eliminarReto(Integer id);



    
}
