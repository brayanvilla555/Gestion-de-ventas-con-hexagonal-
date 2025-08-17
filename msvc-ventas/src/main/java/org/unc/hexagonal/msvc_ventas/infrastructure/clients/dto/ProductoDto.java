package org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private String imagen;
    private Integer stockTienda;
    private Integer stockAlmacen;
}
