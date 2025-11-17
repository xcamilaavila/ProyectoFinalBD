package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.DTO.AsociacionDTO;
import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
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

        // Buscar libro y reto existentes
        LibroModel libro = libroRepo.findById(dto.getIdLibro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        RetoModel reto = retoRepo.findById(dto.getIdReto())
                .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        // Crear ID compuesto
        AsociacionId id = new AsociacionId(dto.getIdLibro(), dto.getIdReto());

        // Validar si ya existe
        if (repo.existsById(id)) {
            throw new RuntimeException("La asociación Libro " + dto.getIdLibro() + " - Reto " + dto.getIdReto() + " ya existe");
        }

        // Crear la asociación
        AsociacionModel asociacion = new AsociacionModel();
        asociacion.setId(id);
        asociacion.setLibro(libro);
        asociacion.setReto(reto);

        // Guardar en BD
        return repo.save(asociacion);
    }


   @Override
   public List<AsociacionModel> listarAsociados() {
    return repo.findAll();
   }

   @Override
   public AsociacionModel buscarAsociacionPorId(Integer idLibro, Integer idReto) {
       AsociacionId id = new AsociacionId(idLibro, idReto);
    return repo.findById(id)
        .orElseThrow(() -> new RecursoNoEncontradoException(
            "Error! La asociación Libro " + idLibro + " - Reto " + idReto + " no se encuentra en la BD"));
    }
   

  @Override
    public String eliminarAsociacion(Integer idLibro, Integer idReto) {

    // Buscar la asociación usando la clave compuesta
    AsociacionId id = new AsociacionId(idLibro, idReto);
    AsociacionModel asociacionExistente = repo.findById(id)
        .orElseThrow(() -> new RuntimeException(
            "No se encontró la asociación Libro " + idLibro + " - Reto " + idReto));

    // Eliminar la asociación si existe
    repo.delete(asociacionExistente);

    return "La asociación Libro " + idLibro + " - Reto " + idReto + " se eliminó con éxito.";
}

}
