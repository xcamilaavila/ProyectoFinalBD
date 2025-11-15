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

import com.apirest.backend_GCLC.DTO.ProgresoRetoDTO;
import com.apirest.backend_GCLC.Model.ProgresoRetoModel;
import com.apirest.backend_GCLC.Service.IProgresoRetoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/ClubLectura/progreso")
public class ProgresoRetoController {
    
    @Autowired IProgresoRetoService progresoService;

    @PostMapping("/insertar")
    ResponseEntity<ProgresoRetoModel> crearProgreso(@Valid @RequestBody ProgresoRetoDTO dto) {
        return new ResponseEntity<>(progresoService.guardarProgresoReto(dto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
   ResponseEntity<List<ProgresoRetoModel>>listarProgresos() {
        return new ResponseEntity<List<ProgresoRetoModel>>(progresoService.listarProgresos(),HttpStatus.OK);
    }
    
    @GetMapping("/buscarProgreso/{id}")
        ResponseEntity <ProgresoRetoModel> buscarProgreso(@PathVariable Integer id) {
        return new ResponseEntity<ProgresoRetoModel>(progresoService.buscarProgresoPorId(id),HttpStatus.OK);
        }

    @PutMapping("/actualizar/{id}")
        ResponseEntity<ProgresoRetoModel>actualizarProgreso(@PathVariable Integer id, @Valid @RequestBody ProgresoRetoModel progreso){
            return new ResponseEntity<ProgresoRetoModel>(progresoService.actualizarProgreso(id, progreso),HttpStatus.OK);
        }
    @DeleteMapping("/eliminar/{id}")
        ResponseEntity<String> eliminarProgreso(@PathVariable Integer id){
        return new ResponseEntity<String>(progresoService.eliminarProgreso(id),HttpStatus.OK);
        }
}
