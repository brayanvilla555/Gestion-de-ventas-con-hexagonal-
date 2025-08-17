package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.Producto;

import java.util.List;

public interface ListProductoUseCase {
    List<Producto> findAll();
    Producto findById(Long id);
}
