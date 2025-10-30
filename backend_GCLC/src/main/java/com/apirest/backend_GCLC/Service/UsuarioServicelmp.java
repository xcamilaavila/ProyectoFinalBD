package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();// findAll me permite recuperar todo
    }
    
}
