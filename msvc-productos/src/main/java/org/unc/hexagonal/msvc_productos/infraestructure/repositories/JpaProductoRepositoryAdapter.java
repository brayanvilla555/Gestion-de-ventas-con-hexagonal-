package org.unc.hexagonal.msvc_productos.infraestructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;
import org.unc.hexagonal.msvc_productos.infraestructure.entities.ProductoEntity;
import org.unc.hexagonal.msvc_productos.infraestructure.mapper.ProductoMapper;

import java.util.List;
import java.util.Optional;

public class JpaProductoRepositoryAdapter  implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaProductoRepository;

    public JpaProductoRepositoryAdapter(JpaProductoRepository jpaProductoRepository) {
        this.jpaProductoRepository = jpaProductoRepository;
    }

    public Producto save(Producto producto) {
        // Mapear dominio -> entity
        ProductoEntity entity = ProductoMapper.toProductoEntity(producto);
        entity = jpaProductoRepository.save(entity);
        return ProductoMapper.toProducto(entity);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        Optional<ProductoEntity> entity = jpaProductoRepository.findById(id);
        return entity.map(ProductoMapper::toProducto);
    }

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> listEntity = jpaProductoRepository.findAll();
        return ProductoMapper.toListProducto(listEntity);
    }

    @Override
    public Optional<Producto> update(Long id, Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto no puede ser null");
        }

        ProductoEntity actual = jpaProductoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No existe un producto con el id: " + id));

        // mapear dominio → entity (sin tocar fechas; las maneja JPA)
        ProductoEntity entityToSave = ProductoMapper.toProductoEntity(producto);
        entityToSave.setId(actual.getId());

        ProductoEntity updated = jpaProductoRepository.save(entityToSave);
        return Optional.of(ProductoMapper.toProducto(updated));
    }

    @Override
    public boolean deleteById(Long id) {
        if (!jpaProductoRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe un producto con el id: " + id);
        }
        jpaProductoRepository.deleteById(id);
        return true;
    }



}
