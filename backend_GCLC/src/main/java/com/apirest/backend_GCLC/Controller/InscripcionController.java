package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.InscripcionModel;
import com.apirest.backend_GCLC.Service.IInscripcionService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping ("/ClubLectura/inscripcion")
public class InscripcionController {
    
    @Autowired IInscripcionService inscripcionService;
    @PostMapping("/insertar")
    public ResponseEntity<?> crearInscripcion(@Valid @RequestBody InscripcionModel inscripcion) {
    try {
        InscripcionModel nuevaInscripcion = inscripcionService.guardarInscripcion(inscripcion);
        return ResponseEntity.ok(nuevaInscripcion);
    } catch (RuntimeException e) {
        // Este catch muestra el mensaje del service directamente en Postman
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @GetMapping("/listar")
    public ResponseEntity<List<InscripcionModel>> listarInscripciones() {
        return new ResponseEntity<>(inscripcionService.listarInscripciones(), HttpStatus.OK);
    }

     @GetMapping("/buscarInscripcion/{id}")
    ResponseEntity <InscripcionModel> buscarInscripcion(@PathVariable Integer id) {
       return new ResponseEntity<InscripcionModel>(inscripcionService.buscarInscripcionPorId(id),HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<InscripcionModel>actualizarInscripcion(@PathVariable Integer id, @Valid @RequestBody  InscripcionModel inscripcion){
        return new ResponseEntity<InscripcionModel>(inscripcionService.actualizarInscripcion(id, inscripcion), HttpStatus.OK);
        }
    

    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> cancelarInscripcion(@PathVariable Integer id){
        return new ResponseEntity<String>(inscripcionService.cancelarInscripcion(id),HttpStatus.OK);
    }
}
