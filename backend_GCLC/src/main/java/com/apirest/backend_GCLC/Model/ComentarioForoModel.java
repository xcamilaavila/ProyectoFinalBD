package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ComentarioForo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioForoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario")
    private Integer idComentario;

    @NotBlank (message="Es obligatorio este campo de respuesta")
    private String contenidoRespuesta;

    @NotNull (message = "El campo de la fecha del comentario es obligatoria")
    private Date fechaComentario;

    // Relación con el foro
    @ManyToOne
    @JoinColumn(name="idForo", nullable = false)
    private ForoModel foro;

    // Relación con el usuario
    @ManyToOne
    @JoinColumn(name="idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name="idComentarioPadre", nullable = true)
    private ComentarioForoModel comentarioPadre;

}
