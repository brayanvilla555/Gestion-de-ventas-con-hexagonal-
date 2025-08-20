package org.unc.hexagonal.msvc_ventas.infrastructure.repositories;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.ItemVentaEntity;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.VentaEntity;
import org.unc.hexagonal.msvc_ventas.infrastructure.mapper.VentaMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaVentaRepositoryAdapter implements VentaRepositoryPort {


    private final JpaVentaRepository jpaVentaRepository;

    public JpaVentaRepositoryAdapter(JpaVentaRepository jpaVentaRepository) {
        this.jpaVentaRepository = jpaVentaRepository;
    }

    @Override
    public Venta createVenta(Venta venta) {
        VentaEntity ventaEntity = VentaMapper.toVentaEntity(venta);

        ventaEntity.getItemsVenta().forEach(item -> item.setSubTotal(item.getCantidad() * item.getPrecio()));

        double total = ventaEntity.getItemsVenta().stream()
                .mapToDouble(ItemVentaEntity::getSubTotal)
                .sum();
        ventaEntity.setTotal(total);

        // Asignar relación inversa
        VentaEntity finalVentaEntity = ventaEntity;
        ventaEntity.getItemsVenta().forEach(item -> item.setVenta(finalVentaEntity));

        ventaEntity = jpaVentaRepository.save(ventaEntity);

        return VentaMapper.toVenta(ventaEntity);
    }

    @Override
    public Optional<Venta> getVenta(Long id) {
        Optional<VentaEntity> venta = jpaVentaRepository.findById(id);
        return venta.map(VentaMapper::toVenta);
    }

    @Override
    public List<Venta> getAllVentas() {
        List<VentaEntity> listVentaEntity = jpaVentaRepository.findAll();
        List<Venta> listVenta = VentaMapper.toListVenta(listVentaEntity);
        return listVenta;
    }

    @Override
    public Optional<Venta> updateVenta(Long id, Venta venta) {
        if (venta == null) {
            throw new IllegalArgumentException("Venta no puede ser null");
        }

        Optional<VentaEntity> ventaEntityOpt = jpaVentaRepository.findById(id);

        if (ventaEntityOpt.isEmpty()) {
            throw new IllegalArgumentException("No existe una venta con el id: " + venta.getId());
        }

        VentaEntity ventaEntityMapper = VentaMapper.toVentaEntity(venta);
        ventaEntityMapper.setId(venta.getId());

        VentaEntity updatedEntity = jpaVentaRepository.save(ventaEntityMapper);

        return Optional.of(VentaMapper.toVenta(updatedEntity));
    }

    @Override
    public boolean deleteVenta(Long id) {
        if (!jpaVentaRepository.existsById(id)) {
            throw new EntityNotFoundException("No existe una venta con el id: " + id);
        }
        jpaVentaRepository.deleteById(id);
        return true;
    }
}
