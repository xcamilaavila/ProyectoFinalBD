package com.apirest.backend_GCLC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.UsuarioModel;
import com.apirest.backend_GCLC.Service.IUsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/ClubLectura/usuario")// esto es el en rutamiento y sirve para identificar de quien estamos hablando
public class UsuarioController {
    @Autowired IUsuarioService usuarioService; // aqui no se inyecta la logica del negocio sino del contrato de operaciones
    @PostMapping("/insertar")
    ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel usuario){
        return new ResponseEntity<UsuarioModel>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }
}
