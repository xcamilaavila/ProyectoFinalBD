package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.RetoModel;
import com.apirest.backend_GCLC.Service.IRetoService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/ClubLectura/reto")

public class RetoController {
    
    @Autowired IRetoService retoService; // aqui no se inyecta la logica del negocio sino del contrato de operaciones
    @PostMapping("/insertar")
    ResponseEntity<RetoModel> crearReto(@Valid @RequestBody RetoModel reto){
        return new ResponseEntity<RetoModel>(retoService.guardarReto(reto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    ResponseEntity<List<RetoModel>>listarReto(){
        return new ResponseEntity<List<RetoModel>>(retoService.listarRetos(),HttpStatus.OK);

    }

    @GetMapping("/buscarReto/{id}")
    ResponseEntity <RetoModel> buscarReto(@PathVariable Integer id) {
       return new ResponseEntity<RetoModel>(retoService.buscarRetoPorId(id),HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarReto(@PathVariable Integer id){
        return new ResponseEntity<String>(retoService.eliminarReto(id),HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    ResponseEntity<RetoModel> actualizarReto(@PathVariable Integer id,@Valid @RequestBody RetoModel reto){
    return new ResponseEntity<RetoModel>(retoService.actualizarReto(id, reto),HttpStatus.OK);
  }
}
