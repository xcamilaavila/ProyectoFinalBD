package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import com.apirest.backend_GCLC.ENUM.EstadoProgresoReto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProgresoReto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgresoRetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProgresoReto")
    private Integer idProgresoReto;

    @NotNull(message = "Es obligatorio llenar este campo")
    @Column(name = "porcentajeAvance")
    private Double porcentajeAvance;

    @NotNull(message = "Es obligatorio llenar este campo")
    private Date fechaActualizacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoProgresoReto estadoProgresoReto;

    @ManyToOne
    @JoinColumn(name = "idLibro")
    private LibroModel libro;

    @ManyToOne
    @JoinColumn (name = "idReto",nullable = false)
    private RetoModel reto;

    @ManyToOne
    @JoinColumn (name = "idInscripcion", nullable = false)
    private InscripcionModel inscripcion;

    @ManyToOne
    @JoinColumn (name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
    

    
}
