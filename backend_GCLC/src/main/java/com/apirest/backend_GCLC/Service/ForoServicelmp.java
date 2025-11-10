package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.ENUM.TipoUsuario;
import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.ForoModel;
import com.apirest.backend_GCLC.Model.UsuarioModel;
import com.apirest.backend_GCLC.Repository.IForoRepository;
import com.apirest.backend_GCLC.Repository.IUsuarioRepository;

@Service//esto es lo que va hacer la logica del negocio

public class ForoServicelmp implements IForoService{

    @Autowired IForoRepository foroRepository;
    @Override
    public ForoModel guardarForo(ForoModel foro) {
    try {
        
        foro.setIdForo(null); // asegurar que se inserte
        return foroRepository.save(foro);
    } catch (Exception e) {
        // Lanza directamente el mensaje al Postman
        throw new RuntimeException("¡Error!, Solo el moderador está autorizado para crear foros");
    }
}


    @Override
    public List<ForoModel> listarForos() {
        return foroRepository.findAll();
    }

    @Override
    public ForoModel buscarForoPorId(Integer id) {
        return foroRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El foro con el ID "+id+", no se encuentra en la BD"));
    }
    
  @Autowired
private IUsuarioRepository usuarioRepository;

@Override
public ForoModel actualizarForo(Integer id, ForoModel foro) {
    try {
        ForoModel foroExistente = buscarForoPorId(id);

        // Validar que el usuario exista
        if (foro.getUsuario() == null || foro.getUsuario().getIdUsuario() == null) {
            throw new RuntimeException("Debe especificar un usuario para actualizar el foro");
        }

        // Buscar el usuario real en la BD
        UsuarioModel usuario = usuarioRepository.findById(foro.getUsuario().getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado en la base de datos"));

        // Verificar que sea moderador
        if (usuario.getTipo() != TipoUsuario.Moderador) {
            throw new RuntimeException("¡Error!, Solo el moderador está autorizado para actualizar foros");
        }

        // Actualizar los campos del foro
        foroExistente.setTemaForo(foro.getTemaForo());
        foroExistente.setMensaje(foro.getMensaje());
        foroExistente.setFechaPublicacion(foro.getFechaPublicacion());

        return foroRepository.save(foroExistente);

    } catch (RuntimeException e) {
        throw e; // mensaje personalizado se mantiene
    } catch (Exception e) {
        throw new RuntimeException("Ocurrió un error al actualizar el foro");
    }
}


    @Override
    public String eliminarForo(Integer id) {
       ForoModel foroExistente = buscarForoPorId(id);
       foroRepository.delete(foroExistente);
       return "El foro con ID "+id+" se elimino con exito.";
    }
    
}
