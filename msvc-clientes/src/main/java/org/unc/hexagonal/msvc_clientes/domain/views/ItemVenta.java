package org.unc.hexagonal.msvc_clientes.domain.views;


import lombok.Getter;

@Getter
public class ItemVenta {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Double precio;
    private Double subTotal;

    public ItemVenta(Long id, Long productoId, Integer cantidad, Double precio, Double subTotal) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }
}
