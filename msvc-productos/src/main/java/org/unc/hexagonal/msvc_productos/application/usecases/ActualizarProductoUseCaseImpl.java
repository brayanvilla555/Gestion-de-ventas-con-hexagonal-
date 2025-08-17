package org.unc.hexagonal.msvc_productos.application.usecases;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.in.ActualizarProductoUseCase;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

public class ActualizarProductoUseCaseImpl implements ActualizarProductoUseCase {
  private final ProductoRepositoryPort productoRepositoryPort;

    public ActualizarProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto actualizar(Long id, Producto data) {
        return productoRepositoryPort.update(id, data).orElseThrow(()-> new RuntimeException("No se pudo actualizar el producto"));
    }

}
