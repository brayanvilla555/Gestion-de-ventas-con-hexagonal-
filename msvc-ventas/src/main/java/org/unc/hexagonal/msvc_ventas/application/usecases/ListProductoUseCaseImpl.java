package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.ListProductoUseCase;

import java.util.List;

public class ListProductoUseCaseImpl implements ListProductoUseCase {
    @Override
    public List<Producto> findAll() {
        return List.of();
    }

    @Override
    public Producto findById(Long id) {
        return null;
    }
}
