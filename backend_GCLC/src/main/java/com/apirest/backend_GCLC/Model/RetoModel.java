package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Reto")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RetoModel {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Positive(message = "El ID no puede ser negativo ni cero")
    private Integer idReto;

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private Date fechaInicio;

    @NotNull(message = "La fecha de Finalizacion es obligatoria")
    private Date fechaFinalizacion;


    
}
