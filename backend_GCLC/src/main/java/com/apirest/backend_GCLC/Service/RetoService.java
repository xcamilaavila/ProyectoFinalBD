package com.apirest.backend_GCLC.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.RetoModel;
import com.apirest.backend_GCLC.Repository.IRetoRepository;

@Service

public class RetoService implements IRetoService {
    @Autowired IRetoRepository retoRepository;
    @Override
    public RetoModel guardarReto(RetoModel reto) {
        return retoRepository.save(reto);
    }

    @Override
    public List<RetoModel> listarRetos() {
        return retoRepository.findAll();
    }

    @Override
    public RetoModel buscarRetoPorId(Integer id) {
        return retoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El reto con el ID "+id+", no se encuentra en la BD"));
    }

    @Override
    public RetoModel actualizarReto(Integer id, RetoModel reto) {
        RetoModel retoExistente = buscarRetoPorId(id);
        retoExistente.setTitulo(reto.getTitulo());
        retoExistente.setDescripcion(reto.getDescripcion());
        retoExistente.setFechaInicio(reto.getFechaInicio());
        retoExistente.setFechaFinalizacion(reto.getFechaFinalizacion());
        return retoRepository.save(retoExistente);
    }

    @Override
    public String eliminarReto(Integer id) {
        RetoModel retoExistente = buscarRetoPorId(id);
        retoRepository.delete(retoExistente);
        return "El reto con el ID "+id+" se elimino con exito.";
    }
    
}
