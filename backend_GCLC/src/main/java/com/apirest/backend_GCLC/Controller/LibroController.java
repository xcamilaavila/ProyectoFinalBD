package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.LibroModel;
import com.apirest.backend_GCLC.Service.ILibroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

}
