package com.apirest.backend_GCLC.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AsociacionId implements Serializable {

    @Column(name = "idLibro")
    private Integer idLibro;

    @Column(name = "idReto")
    private Integer idReto;
}
