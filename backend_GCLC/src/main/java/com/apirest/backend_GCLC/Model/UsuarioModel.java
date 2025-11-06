package com.apirest.backend_GCLC.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel {

    @Id
    private Integer idUsuario;
    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;
    @NotNull(message = "La edad es obligatoria")
    private Integer edad;
    @NotBlank(message = "La ocupación es obligatoria")
    private String ocupacion;
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    private String correoElectronico;
    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    @NotNull(message = "El tipo de usuario es obligatorio")
    @Enumerated(EnumType.STRING) // Guarda el valor como texto ("Lector", "Administrador", "Moderador")
    private TipoUsuario tipo;
    
}
