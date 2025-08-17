package org.unc.hexagonal.msvc_productos.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unc.hexagonal.msvc_productos.infraestructure.entities.ProductoEntity;

public interface JpaProductoRepository extends JpaRepository<ProductoEntity,Long > {
}
