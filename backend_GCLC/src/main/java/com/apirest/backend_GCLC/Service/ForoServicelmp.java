package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.Model.ForoModel;
import com.apirest.backend_GCLC.Repository.IForoRepository;

@Service//esto es lo que va hacer la logica del negocio

public class ForoServicelmp implements IForoService{
    @Autowired IForoRepository foroRepository;

    @Override
    public ForoModel guardarForo(ForoModel foro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarForo'");
    }

    @Override
    public List<ForoModel> listarForos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarForos'");
    }

    @Override
    public ForoModel buscarForoPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarForoPorId'");
    }

    @Override
    public ForoModel actualizarForo(Integer id, ForoModel foro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarForo'");
    }

    @Override
    public String eliminarForo(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarForo'");
    }
    
}
