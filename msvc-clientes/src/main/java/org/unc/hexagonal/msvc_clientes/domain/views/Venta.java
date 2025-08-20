package org.unc.hexagonal.msvc_clientes.domain.views;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Venta {
    private Long id;
    private LocalDateTime fechaVenta;
    private DireccionEntrega direccion;
    private List<ItemVenta> itemsVenta = new ArrayList<>();
    private EstadoVenta estado;
    private Double total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Venta(Long id, LocalDateTime fechaVenta, DireccionEntrega direccion, List<ItemVenta> itemsVenta, EstadoVenta estado, Double total, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.direccion = direccion;
        this.itemsVenta = itemsVenta;
        this.estado = estado;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}