package com.apirest.backend_GCLC.Model;

import java.time.LocalDateTime;

import com.apirest.backend_GCLC.ENUM.TemaForo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Foro")
@Data//Para los metodos getters and setters
@AllArgsConstructor
@NoArgsConstructor

public class ForoModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idForo")
    private Integer idForo;

    @Enumerated(EnumType.STRING) // Guarda el valor como texto ("Genero", "Autor", "Tema")
    private TemaForo temaForo;

    private String mensaje;

    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;
    
}
