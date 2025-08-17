package org.unc.hexagonal.msvc_productos.domain.ports.in;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;

public interface ActualizarProductoUseCase {
    Producto actualizar(Long id, Producto data);
}
