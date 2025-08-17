package org.unc.hexagonal.msvc_productos.domain.ports.out;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    Optional<Producto>update(Long id, Producto data);
    boolean deleteById(Long id);
}
