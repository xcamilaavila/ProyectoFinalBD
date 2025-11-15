package com.apirest.backend_GCLC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.DTO.AsociacionDTO;
import com.apirest.backend_GCLC.Model.AsociacionId;
import com.apirest.backend_GCLC.Model.AsociacionModel;
import com.apirest.backend_GCLC.Model.LibroModel;
import com.apirest.backend_GCLC.Model.RetoModel;
import com.apirest.backend_GCLC.Repository.IAsociacionRepository;
import com.apirest.backend_GCLC.Repository.ILibroRepository;
import com.apirest.backend_GCLC.Repository.IRetoRepository;

@Service
public class AsociacionService implements IAsociacionService {

    @Autowired
    private IAsociacionRepository repo;

    @Autowired
    private ILibroRepository libroRepo;

    @Autowired
    private IRetoRepository retoRepo;

    @Override
    public AsociacionModel crearAsociacion(AsociacionDTO dto) {
        
        LibroModel libro = libroRepo.findById(dto.getIdLibro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        
        RetoModel reto = retoRepo.findById(dto.getIdReto())
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));
        
        AsociacionId id = new AsociacionId();
        id.setIdLibro(dto.getIdLibro());
        id.setIdReto(dto.getIdReto());

        AsociacionModel asociacion = new AsociacionModel();
        asociacion.setId(id);
        asociacion.setLibro(libro);
        asociacion.setReto(reto);

        return repo.save(asociacion);
    }
    
}
