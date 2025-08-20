package org.unc.hexagonal.msvc_clientes.domain.ports.in;

import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;

import java.util.Optional;

public interface ActualizarClienteUseCase {
    Optional<Cliente> actualizar(Long id, Cliente cliente);
}
