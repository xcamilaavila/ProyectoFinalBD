package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.ComentarioForoModel;
import com.apirest.backend_GCLC.Service.IComentarioForoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping ("/ClubLectura/comentario")// esto es el en rutamiento y sirve para identificar de quien estamos hablando
public class ComentarioForoController {

    @Autowired IComentarioForoService comentarioService;
    @PostMapping("/insertar")
    ResponseEntity<ComentarioForoModel>crearComentario(@Valid @RequestBody ComentarioForoModel comentario){
        return new ResponseEntity<ComentarioForoModel>(comentarioService.guardarComentarioForo(comentario), HttpStatus.OK);
    }

    @GetMapping("/listar")
    ResponseEntity<List<ComentarioForoModel>>listaComentarioForos() {
        return new ResponseEntity<List<ComentarioForoModel>>(comentarioService.listaComentarioForos(),HttpStatus.OK);
    }
    
    @GetMapping("/buscarComentario/{id}")
    ResponseEntity <ComentarioForoModel> buscarComentario(@PathVariable Integer id) {
       return new ResponseEntity<ComentarioForoModel>(comentarioService.buscarComentarioForoPorId(id),HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarComentarioForo(@PathVariable Integer id){
        return new ResponseEntity<String>(comentarioService.eliminarComentarioForo(id),HttpStatus.OK);
    }

    @PutMapping("/actualizarComentario/{id}")
    ResponseEntity<ComentarioForoModel> actualizarComentarioForo(@PathVariable Integer id,@Valid @RequestBody ComentarioForoModel comentario){
    return new ResponseEntity<ComentarioForoModel>(comentarioService.actualizarComentarioForo(id, comentario),HttpStatus.OK);
  }
}
