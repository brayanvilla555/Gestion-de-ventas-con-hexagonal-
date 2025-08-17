package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;

import java.util.List;
import java.util.Optional;

public interface RetriveVentaUseCase {
    Optional<Venta> getVenta(Long id);
    List<Venta> getAllVentas();
}