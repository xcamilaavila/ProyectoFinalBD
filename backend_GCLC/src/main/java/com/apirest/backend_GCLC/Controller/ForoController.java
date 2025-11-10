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

import com.apirest.backend_GCLC.Model.ForoModel;
import com.apirest.backend_GCLC.Service.IForoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/ClubLectura/foro")
public class ForoController {
    
    @Autowired IForoService foroService;
    @PostMapping("/insertar")
    public ResponseEntity<?> crearForo(@Valid @RequestBody ForoModel foro) {
    try {
        ForoModel nuevoForo = foroService.guardarForo(foro);
        return ResponseEntity.ok(nuevoForo);
    } catch (RuntimeException e) {
        // Este catch muestra el mensaje del service directamente en Postman
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @GetMapping("/listar")
    public ResponseEntity<List<ForoModel>> listarForos() {
        return new ResponseEntity<>(foroService.listarForos(), HttpStatus.OK);
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<ForoModel> buscarForoPorId(@PathVariable Integer id) {
        return new ResponseEntity<ForoModel>(foroService.buscarForoPorId(id), HttpStatus.OK);
    }

    @PutMapping("/actualizarForo/{id}")
    public ResponseEntity<?> actualizarForo(@PathVariable Integer id, @Valid @RequestBody ForoModel foro) {
    try {
        ForoModel foroActualizado = foroService.actualizarForo(id, foro); 
        return ResponseEntity.ok(foroActualizado);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}


    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarForo(@PathVariable Integer id){
        return new ResponseEntity<String>(foroService.eliminarForo(id),HttpStatus.OK);
    }

}
