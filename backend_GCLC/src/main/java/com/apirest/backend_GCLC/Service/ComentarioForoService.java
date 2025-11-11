package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.ComentarioForoModel;
import com.apirest.backend_GCLC.Repository.IComentarioForoRepository;
import com.apirest.backend_GCLC.Repository.IForoRepository;
import com.apirest.backend_GCLC.Repository.IUsuarioRepository;

@Service   

public class ComentarioForoService implements IComentarioForoService{
    
    @Autowired IComentarioForoRepository comentarioForoRepository;

    
    @Autowired
    private IForoRepository foroRepository; // ✅ inyección del repositorio de foros

    @Autowired
    private IUsuarioRepository usuarioRepository; // ✅ inyección del repositorio de usuarios

    @Override
    public ComentarioForoModel guardarComentarioForo(ComentarioForoModel comentario) {

    // 🔹 Validar que el foro exista
    foroRepository.findById(comentario.getForo().getIdForo())
        .orElseThrow(() -> new RecursoNoEncontradoException("El foro especificado no existe"));

    // 🔹 Validar que el usuario exista
    usuarioRepository.findById(comentario.getUsuario().getIdUsuario())
        .orElseThrow(() -> new RecursoNoEncontradoException("El usuario especificado no existe"));

    // 🔹 Si el comentario tiene un comentarioPadre, buscamos ese padre en la BD y validamos
    if (comentario.getComentarioPadre() != null && comentario.getComentarioPadre().getIdComentario() != null) {
        ComentarioForoModel comentarioPadre = comentarioForoRepository.findById(
            comentario.getComentarioPadre().getIdComentario()
        ).orElseThrow(() -> new RecursoNoEncontradoException("El comentario padre no existe"));

        // Validar que el padre pertenezca al mismo foro
        if (!comentarioPadre.getForo().getIdForo().equals(comentario.getForo().getIdForo())) {
            throw new IllegalArgumentException("El comentario padre debe pertenecer al mismo foro");
        }

        comentario.setComentarioPadre(comentarioPadre);
    }

    // 🔹 Guardamos normalmente
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
