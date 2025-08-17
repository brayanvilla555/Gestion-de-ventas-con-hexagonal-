package org.unc.hexagonal.msvc_productos.domain.ports.in;

import org.unc.hexagonal.msvc_productos.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;

public interface ActualizarPrecioEstadoUseCase {
    Producto actualizarEstado(Long id, EstadoProducto estado);
    Producto actualizarPrecio(Long id, double precio);
}
