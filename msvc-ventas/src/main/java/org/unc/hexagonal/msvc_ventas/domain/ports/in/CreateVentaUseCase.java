package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;

public interface CreateVentaUseCase {
    Venta createVenta(Venta venta);
}