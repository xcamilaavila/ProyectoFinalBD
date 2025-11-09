package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.LibroModel;
import com.apirest.backend_GCLC.Service.ILibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/ClubLectura/libro")
public class LibroController {

    @Autowired ILibroService libroService;
    

    @PostMapping("/insertar")
    ResponseEntity<LibroModel> crearLibro(@RequestBody LibroModel libro) {
        
        return new ResponseEntity<LibroModel>(libroService.guardaLibro(libro), HttpStatus.CREATED);
}
    @GetMapping("/listar")
    public ResponseEntity<List<LibroModel>> listarLibros() {
        return new ResponseEntity<>(libroService.listarLibros(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LibroModel> buscarLibroPorId(@PathVariable Integer id) {
        return new ResponseEntity<LibroModel>(libroService.buscarLibroPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Integer id) {
        String mensaje = libroService.eliminarLibro(id);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<LibroModel> actualizarLibro(@PathVariable Integer id, @RequestBody LibroModel libro) {
        LibroModel libroActualizado = libroService.actualizarLibro(id, libro);
        if (libroActualizado != null) {
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
