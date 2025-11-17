package com.apirest.backend_GCLC.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "Asociacion")//la tabla física que guarda estas relaciones.
public class AsociacionModel {

    @EmbeddedId
    private AsociacionId id;

    @ManyToOne
    @MapsId("idLibro")
    @JoinColumn(name = "idLibro")
    private LibroModel libro;

    @ManyToOne
    @MapsId("idReto")
    @JoinColumn(name = "idReto")
    private RetoModel reto;
    
}
