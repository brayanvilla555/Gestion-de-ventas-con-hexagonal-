package org.unc.hexagonal.msvc_ventas.domain.ports.out;

import org.unc.hexagonal.msvc_ventas.domain.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto p);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    void deleteById(Long id);
}
