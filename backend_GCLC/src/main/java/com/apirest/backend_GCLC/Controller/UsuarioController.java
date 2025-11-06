package com.apirest.backend_GCLC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend_GCLC.Model.UsuarioModel;
import com.apirest.backend_GCLC.Service.IUsuarioService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping ("/ClubLectura/usuario")// esto es el en rutamiento y sirve para identificar de quien estamos hablando
public class UsuarioController {

    @Autowired IUsuarioService usuarioService; // aqui no se inyecta la logica del negocio sino del contrato de operaciones
    @PostMapping("/insertar")
    ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel usuario){
        return new ResponseEntity<UsuarioModel>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    ResponseEntity<List<UsuarioModel>>listarUsuarios(){
        return new ResponseEntity<List<UsuarioModel>>(usuarioService.listarUsuarios(),HttpStatus.OK);

    }

    @GetMapping("/buscarUsuario/{id}")
    ResponseEntity <UsuarioModel> buscarUsuario(@PathVariable Integer id) {
       return new ResponseEntity<UsuarioModel>(usuarioService.buscarUsuarioPorId(id),HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    ResponseEntity<String> eliminarUsuario(@PathVariable Integer id){
        return new ResponseEntity<String>(usuarioService.eliminarUsuario(id),HttpStatus.OK);
    }

    @PutMapping("/actualizarUsuario/{id}")
    ResponseEntity<UsuarioModel> actualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioModel usuario){
    return new ResponseEntity<UsuarioModel>(usuarioService.actualizarUsuario(id, usuario),HttpStatus.OK);
  }
}
