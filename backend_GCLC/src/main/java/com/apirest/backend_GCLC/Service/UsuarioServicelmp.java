package com.apirest.backend_GCLC.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.UsuarioModel;
import com.apirest.backend_GCLC.Repository.IUsuarioRepository;
@Service//esto es lo que va hacer la logica del negocio

public class UsuarioServicelmp implements IUsuarioService{
    @Autowired IUsuarioRepository usuarioRepository;
    @Override
    public UsuarioModel guardarUsuario(UsuarioModel usuario) { //aqui no se implementa lo de insert, into, eso lo hace el jprRepository
       return usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioModel buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El empleado con el ID "+id+", no se encuentra en la BD"));
    }
    @Override
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarUsuario'");
    }
    @Override
    public String eliminarUsuario(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarUsuario'");
    }
    @Override
    public List<UsuarioModel> listarUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarUsuarios'");
    }


    
}
