package org.unc.hexagonal.msvc_productos.application.usecases;

import org.unc.hexagonal.msvc_productos.domain.ports.in.EliminarProductoUseCase;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

public class EliminarProductoUseCaseImpl implements EliminarProductoUseCase {
    private final ProductoRepositoryPort productoRepositoryPort;

    public EliminarProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public boolean eliminar(Long id) {
            productoRepositoryPort.deleteById(id);
        return false;
    }
}
