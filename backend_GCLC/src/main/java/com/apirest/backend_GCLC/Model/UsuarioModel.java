package com.apirest.backend_GCLC.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    private Integer idUsuario;
    private String nombreCompleto;
    private Integer edad;
    private String ocupacion;
    private String correoElectronico;
    private String telefono;
    @Enumerated(EnumType.STRING) // Guarda el valor como texto ("Lector", "Administrador", "Moderador")
    private TipoUsuario tipo;
    
}
