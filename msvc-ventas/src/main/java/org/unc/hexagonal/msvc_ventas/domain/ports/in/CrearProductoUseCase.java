package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;

public interface CrearProductoUseCase {
    Producto create(Producto producto);
    Producto actualizarEstado(Long id, EstadoProducto estado);
    Producto actualizarPrecio(Long id, double precio);
}
