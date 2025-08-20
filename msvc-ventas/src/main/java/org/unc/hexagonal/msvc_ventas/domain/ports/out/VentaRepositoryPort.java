package org.unc.hexagonal.msvc_ventas.domain.ports.out;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaRepositoryPort {
    Venta createVenta(Venta venta);
    Optional<Venta> getVenta(Long id);
    List<Venta> getAllVentas();
    Optional<Venta> updateVenta(Long id,Venta venta);
    boolean deleteVenta(Long id);
    List<Venta> getVentaByClienteId(Long clienteId);
}