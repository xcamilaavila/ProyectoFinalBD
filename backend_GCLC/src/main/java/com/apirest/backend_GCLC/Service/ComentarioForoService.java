package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listaComentarioForos'");
    }

    @Override
    public ComentarioForoModel buscarComentarioForoPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarComentarioForoPorId'");
    }

    @Override
    public ComentarioForoModel actualizarComentarioForo(Integer id, ComentarioForoModel comentario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarComentarioForo'");
    }

    @Override
    public String eliminarComentarioForo(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarComentarioForo'");
    }

   


}
