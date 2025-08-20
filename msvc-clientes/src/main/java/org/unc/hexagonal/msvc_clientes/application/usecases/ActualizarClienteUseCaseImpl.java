package org.unc.hexagonal.msvc_clientes.application.usecases;


import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.ActualizarClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;

import java.util.Optional;

public class ActualizarClienteUseCaseImpl implements ActualizarClienteUseCase {
  private final ClienteRepositoryPort clienteRepositoryPort;

    public ActualizarClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }


    @Override
    public Optional<Cliente> actualizar(Long id, Cliente cliente) {
        return clienteRepositoryPort.update(id, cliente);
    }
}
