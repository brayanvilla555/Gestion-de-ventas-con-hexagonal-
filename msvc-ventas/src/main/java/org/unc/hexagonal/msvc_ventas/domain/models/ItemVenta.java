package org.unc.hexagonal.msvc_ventas.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenta {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Double precio;
    private Double subTotal;
    private Venta venta;

    public void calcularSubTotal() {
        this.subTotal = cantidad * precio;
    }

    public void asignarVenta(Venta venta) {
        if (this.venta != null) {
            throw new IllegalStateException("La venta ya fue asignada");
        }
        this.venta = venta;
    }
}
