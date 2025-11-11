package com.apirest.backend_GCLC.Service;

import java.util.List;

import com.apirest.backend_GCLC.Model.ComentarioForoModel;

public interface IComentarioForoService {
    
    public ComentarioForoModel guardarComentarioForo(ComentarioForoModel comentario);

    public List<ComentarioForoModel> listaComentarioForos();
    public ComentarioForoModel buscarComentarioForoPorId(Integer id);
    public ComentarioForoModel actualizarComentarioForo(Integer id, ComentarioForoModel comentario);
    public String eliminarComentarioForo(Integer id);
    // esto es una validacion y sirve para saber cuantos subcomentarios tiene un comentario principal o un subcomentario tiene el subcomentario 
    


}

