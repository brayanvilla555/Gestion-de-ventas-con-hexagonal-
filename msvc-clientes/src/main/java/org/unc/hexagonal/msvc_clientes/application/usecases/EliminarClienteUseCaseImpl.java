package org.unc.hexagonal.msvc_clientes.application.usecases;

import org.unc.hexagonal.msvc_clientes.domain.ports.in.EliminarClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;

public class EliminarClienteUseCaseImpl implements EliminarClienteUseCase {
    private final ClienteRepositoryPort clienteRepositoryPort;


    public EliminarClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public boolean eliminar(Long id) {
        return clienteRepositoryPort.deleteById(id);
    }
}
