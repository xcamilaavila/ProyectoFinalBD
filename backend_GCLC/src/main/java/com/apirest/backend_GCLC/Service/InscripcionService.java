package com.apirest.backend_GCLC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend_GCLC.ENUM.EstadoInscripcion;
import com.apirest.backend_GCLC.ENUM.TipoUsuario;
import com.apirest.backend_GCLC.Exception.RecursoNoEncontradoException;
import com.apirest.backend_GCLC.Model.InscripcionModel;
import com.apirest.backend_GCLC.Repository.IInscripcionRepository;
import com.apirest.backend_GCLC.Repository.IUsuarioRepository;

@Service
public class InscripcionService implements IInscripcionService {
    
    @Autowired IInscripcionRepository inscripcionRepository;
    @Autowired IUsuarioRepository usuarioRepository;

    @Override
        public InscripcionModel guardarInscripcion(InscripcionModel inscripcion) {
        try {
            inscripcion.setIdInscripcion(null);

            var usuario = usuarioRepository.findById(inscripcion.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("¡Error! El usuario no existe."));

            if (usuario.getTipo() != TipoUsuario.Lector) {
                throw new RuntimeException("¡Error! Solo los usuarios con rol lector se inscriben a los retos de lectura.");
            }

            return inscripcionRepository.save(inscripcion);

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("¡Error! El usuario ya está inscrito en este reto.");
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("¡Error inesperado al guardar la inscripción!");
        }
    }

    @Override
    public List<InscripcionModel> listarInscripciones() {
      return inscripcionRepository.findAll();
    }

    @Override
    public InscripcionModel buscarInscripcionPorId(Integer id) {

        return inscripcionRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("Error! la inscripcion con el ID "+id+", no se encuentra en la BD"));
    }

    @Override
    public String cancelarInscripcion(Integer id) {
    InscripcionModel inscripcionExistente = buscarInscripcionPorId(id);

    // Cambiar el estado a "Cancelado"
    inscripcionExistente.setEstadoInscripcion(EstadoInscripcion.Cancelado);

    // Guardar el cambio
    inscripcionRepository.save(inscripcionExistente);

    return "La inscripción con ID " + id + " ha sido cancelada correctamente.";
}


    @Override
    public InscripcionModel actualizarInscripcion(Integer id, InscripcionModel inscripcion) {
       InscripcionModel inscripcionExistente = buscarInscripcionPorId(id);
       inscripcionExistente.setFecha(inscripcion.getFecha());
       inscripcionExistente.setEstadoInscripcion(inscripcion.getEstadoInscripcion());
       return inscripcionRepository.save(inscripcionExistente);

    }
}
