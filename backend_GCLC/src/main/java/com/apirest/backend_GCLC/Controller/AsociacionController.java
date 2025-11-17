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

import com.apirest.backend_GCLC.DTO.AsociacionDTO;
import com.apirest.backend_GCLC.Model.AsociacionModel;

import com.apirest.backend_GCLC.Service.IAsociacionService;

@RestController
@RequestMapping("/ClubLectura/asociacion")
public class AsociacionController {

    @Autowired
    private IAsociacionService asociacionService;

    @PostMapping("/insertar")
    public ResponseEntity<AsociacionModel> crearAsociacion(@RequestBody AsociacionDTO dto) {
        return new ResponseEntity<>(asociacionService.crearAsociacion(dto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    ResponseEntity<List<AsociacionModel>>listaComentarioForos() {
        return new ResponseEntity<List<AsociacionModel>>(asociacionService.listarAsociados(),HttpStatus.OK);
    }
 
    @GetMapping("/buscar/{idLibro}/{idReto}")
    public ResponseEntity<AsociacionModel> buscarAsociacion(@PathVariable Integer idLibro, @PathVariable Integer idReto) {
        return new ResponseEntity<>(asociacionService.buscarAsociacionPorId(idLibro, idReto), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idLibro}/{idReto}")
    public ResponseEntity<String> eliminarAsociacion(@PathVariable Integer idLibro, @PathVariable Integer idReto) {
        return new ResponseEntity<>(asociacionService.eliminarAsociacion(idLibro, idReto), HttpStatus.OK);
    }
}
