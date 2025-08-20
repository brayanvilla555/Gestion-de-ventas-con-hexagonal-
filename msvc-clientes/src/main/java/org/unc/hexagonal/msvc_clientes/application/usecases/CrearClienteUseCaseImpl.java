package org.unc.hexagonal.msvc_clientes.application.usecases;

import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.CrearClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;

public class CrearClienteUseCaseImpl implements CrearClienteUseCase {

   private final ClienteRepositoryPort clienteRepositoryPort;

    public CrearClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }


    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepositoryPort.save(cliente);
    }
}
