package org.unc.hexagonal.msvc_ventas.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.VentaEntity;

import java.util.List;

@Repository
public interface JpaVentaRepository extends JpaRepository<VentaEntity, Long> {
    List<VentaEntity> findByClienteId(Long clienteId);
}
