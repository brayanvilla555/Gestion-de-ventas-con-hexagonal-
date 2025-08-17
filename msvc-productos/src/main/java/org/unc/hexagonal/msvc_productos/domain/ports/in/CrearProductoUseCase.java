package org.unc.hexagonal.msvc_productos.domain.ports.in;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;

public interface CrearProductoUseCase {
    Producto crear(Producto p);
}
