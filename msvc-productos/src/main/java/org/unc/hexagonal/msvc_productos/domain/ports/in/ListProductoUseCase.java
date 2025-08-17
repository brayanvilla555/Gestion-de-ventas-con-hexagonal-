package org.unc.hexagonal.msvc_productos.domain.ports.in;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;

import java.util.List;

public interface ListProductoUseCase {
    Producto buscarById(Long id);
    List<Producto> listar();
}
