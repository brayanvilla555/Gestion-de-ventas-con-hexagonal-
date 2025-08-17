package org.unc.hexagonal.msvc_productos.application.usecases;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.in.ListProductoUseCase;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

import java.util.List;

public class ListProductoUseCaseImpl implements ListProductoUseCase {
   private final ProductoRepositoryPort productoRepositoryPort;

    public ListProductoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto buscarById(Long id) {
        return productoRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @Override
    public List<Producto> listar() {
        return productoRepositoryPort.findAll();
    }
}
