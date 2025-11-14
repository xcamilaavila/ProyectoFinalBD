package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.DTO.ProgresoRetoDTO;
import com.apirest.backend_GCLC.Exception.LibroNoAsociadoException;
import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.InscripcionModel;
import com.apirest.backend_GCLC.Model.LibroModel;
import com.apirest.backend_GCLC.Model.ProgresoRetoModel;
import com.apirest.backend_GCLC.Model.RetoModel;
import com.apirest.backend_GCLC.Model.UsuarioModel;
import com.apirest.backend_GCLC.Repository.IAsociacionRepository;
import com.apirest.backend_GCLC.Repository.IInscripcionRepository;
import com.apirest.backend_GCLC.Repository.ILibroRepository;
import com.apirest.backend_GCLC.Repository.IProgresoRetoRepository;
import com.apirest.backend_GCLC.Repository.IRetoRepository;
import com.apirest.backend_GCLC.Repository.IUsuarioRepository;

@Service
public class ProgresoRetoService implements IProgresoRetoService {

    @Autowired IProgresoRetoRepository progresoRetoRepository;
    @Autowired IAsociacionRepository asociacionRepository;
    @Autowired IRetoRepository retoRepository;
    @Autowired ILibroRepository libroRepository;
    @Autowired IUsuarioRepository usuarioRepository;
    @Autowired IInscripcionRepository inscripcionRepository;

    @Override
    public ProgresoRetoModel guardarProgresoReto(ProgresoRetoDTO dto) {

        ProgresoRetoModel progreso = new ProgresoRetoModel();
        progreso.setPorcentajeAvance(dto.getPorcentajeAvance());
        progreso.setFechaActualizacion(dto.getFechaActualizacion());
        progreso.setEstado(dto.getEstado());

        // Cargar entidades reales desde BD
        LibroModel libro = libroRepository.findById(dto.getLibro())
            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        RetoModel reto = retoRepository.findById(dto.getReto())
            .orElseThrow(() -> new RuntimeException("Reto no encontrado"));

        UsuarioModel usuario = usuarioRepository.findById(dto.getUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        InscripcionModel inscripcion = inscripcionRepository.findById(dto.getInscripcion())
            .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        // Validación libro-reto
        if (!asociacionRepository.existsByIdIdLibroAndIdIdReto(libro.getIdLibro(), reto.getIdReto())) {
            throw new LibroNoAsociadoException(
                "Error: El libro con ID " + libro.getIdLibro() +
                " no está asociado al reto con ID " + reto.getIdReto()
            );
        }

        // Asociar las entidades reales
        progreso.setLibro(libro);
        progreso.setReto(reto);
        progreso.setUsuario(usuario);
        progreso.setInscripcion(inscripcion);

        return progresoRetoRepository.save(progreso);
    }



        
    @Override
    public List<ProgresoRetoModel> listarProgresos() {
        return progresoRetoRepository.findAll();
    }

    @Override
    public ProgresoRetoModel buscarProgresoPorId(Integer id) {
        return progresoRetoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! El progreso con el ID "+id+", no se encuentra en la BD"));
    }

    @Override
    public ProgresoRetoModel actualizarProgreso(Integer id, ProgresoRetoModel progreso) {
        ProgresoRetoModel progresoExiste = buscarProgresoPorId(id);
        progresoExiste.setEstado(progreso.getEstado());
        progresoExiste.setFechaActualizacion(progreso.getFechaActualizacion());
        progresoExiste.setPorcentajeAvance(progreso.getPorcentajeAvance());
        return progresoRetoRepository.save(progresoExiste);
    }

    @Override
    public String eliminarProgreso(Integer id) {
        ProgresoRetoModel progresoExistente = buscarProgresoPorId(id);
        progresoRetoRepository.delete(progresoExistente);
        return "El progreso con el ID "+id+" se elimino con exito.";
    }

}
