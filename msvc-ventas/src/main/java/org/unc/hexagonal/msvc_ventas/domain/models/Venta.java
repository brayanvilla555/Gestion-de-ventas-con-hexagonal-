package org.unc.hexagonal.msvc_ventas.domain.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Venta {
    private final Long id;
    private final LocalDateTime fechaVenta;
    private final DireccionEntrega direccion; // Value Object
    private final Long clienteId;
    private final List<ItemVenta> itemsVenta;
    private EstadoVenta estado;
    private Double total;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Venta(Long id, LocalDateTime fechaVenta, DireccionEntrega direccion, Long clienteId,
                 List<ItemVenta> itemsVenta, EstadoVenta estado,Double total,
                 LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.direccion = direccion;
        this.clienteId = clienteId;
        this.itemsVenta = itemsVenta != null ? new ArrayList<>(itemsVenta) : new ArrayList<>();
        this.estado = estado;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void calcularTotal() {
        this.total = itemsVenta.stream()
                .mapToDouble(ItemVenta::getSubTotal)
                .sum();
    }

    public void agregarItem(ItemVenta item) {
        item.asignarVenta(this); // Uso del método consistente
        item.calcularSubTotal();
        this.itemsVenta.add(item);
        calcularTotal();
    }

    public void cancelarVenta() {
        this.estado = EstadoVenta.CANCELADA;
    }

    public List<ItemVenta> getItemsVenta() {
        return Collections.unmodifiableList(itemsVenta); // Evita modificaciones externas
    }
}
