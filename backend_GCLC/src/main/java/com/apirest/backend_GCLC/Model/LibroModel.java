package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import com.apirest.backend_GCLC.ENUM.Portada;
import com.apirest.backend_GCLC.ENUM.EstadoLectura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Positive(message = "El ID no puede ser negativo ni cero")
    private Integer idLibro;

    @NotBlank(message = "El título del libro es obligatorio")
    private String titulo;

    @NotBlank(message = "El autor del libro es obligatorio")
    private String autor;

    @NotBlank(message = "El género del libro es obligatorio")
    private String genero;

    @NotNull(message = "El año de publicación es obligatorio")
    private Date ano_publicacion;

    @NotBlank(message = "La sinopsis es obligatoria")
    private String sinopsis;

    @Enumerated(EnumType.STRING)
    //puede quedar en null 
    @Column(nullable = true)// el campo se puede llenar o no
    private Portada portada;

    @NotNull// el campo obligatoriamente debe tener algo escrito
    @Enumerated(EnumType.STRING)
    private EstadoLectura estadoLectura;

    @NotNull(message = "La fecha de selección del club es obligatoria")
    private Date fechaSeleccionClub;

}
