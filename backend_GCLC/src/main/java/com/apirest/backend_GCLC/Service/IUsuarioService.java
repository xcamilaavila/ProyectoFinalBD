package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.UsuarioModel;

public interface IUsuarioService {
    // Aqui vamos a definir todos los contratos de operaciones
    //Los contratos de operaciones son los encabezados de todos los metodos que se van a implementar.
    //Los contratos de operacion en este momento son las operaciones CRUD

    public UsuarioModel guardarUsuario(UsuarioModel usuario);
    public List<UsuarioModel> listarUsuarios();
}
