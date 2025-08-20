package org.unc.hexagonal.msvc_clientes.domain.ports.in;


import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ListClienteUseCase {
    Optional<Cliente> buscarById(Long id);
    List<Cliente> listar();
}
