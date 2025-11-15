package com.apirest.backend_GCLC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private IAsociacionService service;

    @PostMapping("/insertar")
    public ResponseEntity<AsociacionModel> crearAsociacion(@RequestBody AsociacionDTO dto) {
        return new ResponseEntity<>(service.crearAsociacion(dto), HttpStatus.CREATED);
    }
    
}
