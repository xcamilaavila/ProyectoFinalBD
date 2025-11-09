package com.apirest.backend_GCLC.Model;

import com.apirest.backend_GCLC.ENUM.TipoUsuario;

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
    @Positive(message = "El ID no puede ser negativo ni cero")
    private Integer idUsuario;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @NotNull(message = "La edad es obligatoria")
    private Integer edad;

    @NotBlank(message = "La ocupación es obligatoria")
    private String ocupacion;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe ingresar un correo electrónico válido")
    private String correoElectronico;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefono;
    
    
    @Enumerated(EnumType.STRING) // Guarda el valor como texto ("Lector", "Administrador", "Moderador")
    private TipoUsuario tipo;
    
}
