package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.ForoModel;

public interface IForoService {
// Aqui vamos a definir todos los contratos de operaciones
//Los contratos de operaciones son los encabezados de todos los metodos que se van a implementar.
//Los contratos de operacion en este momento son las operaciones CRUD

    public ForoModel guardarForo(ForoModel foro);
    public List<ForoModel> listarForos();
    public ForoModel buscarForoPorId(Integer id);
    public ForoModel actualizarForo(Integer id, ForoModel foro);
    public String eliminarForo(Integer id);
    
}
