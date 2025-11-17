package com.apirest.backend_GCLC.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable//la clave compuesta que asegura que no se repitan combinaciones libro-reto.
@AllArgsConstructor
@NoArgsConstructor
public class AsociacionId implements Serializable //Solo sirve para que JPA pueda guardar y manejar la clave compuesta. 
{

    @Column(name = "idLibro")
    private Integer idLibro;

    @Column(name = "idReto")
    private Integer idReto;
}
