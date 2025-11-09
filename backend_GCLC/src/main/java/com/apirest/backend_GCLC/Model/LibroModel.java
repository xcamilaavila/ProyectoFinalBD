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

     public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getAno_publicacion() {
        return ano_publicacion;
    }

    public void setAno_publicacion(Date ano_publicacion) {
        this.ano_publicacion = ano_publicacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

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
