package org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ClienteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String numeroIdentificacion;
    private Boolean estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
