package org.unc.hexagonal.msvc_productos.application.usecases;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.in.CrearProductoUseCase;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

public class CrearProductoUseCaseImpl implements CrearProductoUseCase {

   private final ProductoRepositoryPort repositoryPort;

    public CrearProductoUseCaseImpl(ProductoRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Producto crear(Producto producto) {
        return repositoryPort.save(producto);
    }
}
