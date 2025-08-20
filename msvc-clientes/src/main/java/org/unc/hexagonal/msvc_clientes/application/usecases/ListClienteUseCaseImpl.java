package org.unc.hexagonal.msvc_clientes.application.usecases;



import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.ListClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;

import java.util.List;
import java.util.Optional;

public class ListClienteUseCaseImpl implements ListClienteUseCase {
   private final ClienteRepositoryPort clienteRepositoryPort;

    public ListClienteUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Optional<Cliente> buscarById(Long id) {
        return clienteRepositoryPort.findById(id);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepositoryPort.findAll();
    }

}
