package org.unc.hexagonal.msvc_clientes.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unc.hexagonal.msvc_clientes.infraestructure.entities.ClienteEntity;

public interface JpaClienteRepository extends JpaRepository<ClienteEntity,Long > {
}
