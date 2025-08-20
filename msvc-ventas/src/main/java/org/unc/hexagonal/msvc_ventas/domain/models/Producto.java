package org.unc.hexagonal.msvc_ventas.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private String imagen;
    private Integer stockTienda;
    private Integer stockAlmacen;
}