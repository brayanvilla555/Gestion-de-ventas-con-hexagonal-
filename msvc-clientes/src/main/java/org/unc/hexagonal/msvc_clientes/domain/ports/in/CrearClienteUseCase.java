package org.unc.hexagonal.msvc_clientes.domain.ports.in;

import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;

public interface CrearClienteUseCase {
    Cliente crear(Cliente cliente);
}
