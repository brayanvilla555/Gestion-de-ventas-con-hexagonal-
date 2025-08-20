package org.unc.hexagonal.msvc_clientes.domain.ports.out;


import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
    Optional<Cliente>update(Long id, Cliente cliente);
    boolean deleteById(Long id);
}
