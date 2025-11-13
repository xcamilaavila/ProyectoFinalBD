package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import com.apirest.backend_GCLC.ENUM.EstadoInscripcion;

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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "Inscripcion",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"idUsuario", "idReto"})
    }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscripcionModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idInscripcion")
    private Integer idInscripcion;

    
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idReto", nullable = false)
    private RetoModel reto;

    @NotNull(message = "La fecha es obligatoria")
    private Date fecha;

    @Enumerated(EnumType.STRING)
    private EstadoInscripcion estadoInscripcion;
    
}
