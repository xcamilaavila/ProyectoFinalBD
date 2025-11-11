package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.ComentarioForoModel;
import com.apirest.backend_GCLC.Repository.IComentarioForoRepository;

@Service   

public class ComentarioForoService implements IComentarioForoService{
    
    @Autowired IComentarioForoRepository comentarioForoRepository;

    @Override
    public ComentarioForoModel guardarComentarioForo(ComentarioForoModel comentario) {
        return comentarioForoRepository.save(comentario);
       
    }

    @Override
    public List<ComentarioForoModel> listaComentarioForos() {
        return comentarioForoRepository.findAll();
    }

    @Override
    public ComentarioForoModel buscarComentarioForoPorId(Integer id) {
        return comentarioForoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El comentario con el ID "+id+", no se encuentra en la BD"));
    }

    @Override
    public ComentarioForoModel actualizarComentarioForo(Integer id, ComentarioForoModel comentario) {
       ComentarioForoModel ComentarioExistente = buscarComentarioForoPorId(id);
       ComentarioExistente.setContenidoRespuesta(comentario.getContenidoRespuesta());
       ComentarioExistente.setFechaComentario(comentario.getFechaComentario());
       return comentarioForoRepository.save(ComentarioExistente);
    }

    @Override
    public String eliminarComentarioForo(Integer id) {
       //Buscamos el comentario
       ComentarioForoModel ComentarioExistente = buscarComentarioForoPorId(id); // si el comentario existe
       //Se elimina el comentario solo si existe
        comentarioForoRepository.delete(ComentarioExistente);
        return "El comentario con ID "+id+" se elimino con exito.";

    }

   


}
