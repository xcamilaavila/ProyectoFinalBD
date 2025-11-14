package com.apirest.backend_GCLC.DTO;

import java.sql.Date;

import com.apirest.backend_GCLC.ENUM.EstadoProgresoReto;

import lombok.Data;

@Data
public class ProgresoRetoDTO {
    private Integer idProgresoReto;
    private double porcentajeAvance;
    private Date fechaActualizacion;
    private EstadoProgresoReto estado;


    private Integer libro;       // ID del libro
    private Integer usuario;     // ID del usuario
    private Integer reto;        // ID del reto
    private Integer inscripcion; // ID de la inscripcion

    
}
