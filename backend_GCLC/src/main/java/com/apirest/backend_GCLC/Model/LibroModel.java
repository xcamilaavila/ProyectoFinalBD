package com.apirest.backend_GCLC.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


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
    private Integer idLibro;

    private String titulo;
    private String autor;
    private String genero;
    private Date ano_publicacion;
    private String sinopsis;

    @Enumerated(EnumType.STRING)
    //puede quedar en null 
    @Column(nullable = true)
    private Portada portada;

    @Enumerated(EnumType.STRING)
    // puede quedar en null 
    @Column(nullable = true)
    private EstadoLectura estadoLectura;

    private Date fechaSeleccionClub;

}
