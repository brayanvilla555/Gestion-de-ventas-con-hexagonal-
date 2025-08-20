package org.unc.hexagonal.msvc_clientes.infraestructure.repositories;

import org.springframework.stereotype.Component;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;
import org.unc.hexagonal.msvc_clientes.infraestructure.entities.ClienteEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final JpaClienteRepository jpaClienteRepository;

    public JpaClienteRepositoryAdapter(JpaClienteRepository jpaClienteRepository) {
        this.jpaClienteRepository = jpaClienteRepository;
    }


    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity =ClienteEntity.fromDomainModel(cliente);
        ClienteEntity clienteGuardado= jpaClienteRepository.save(clienteEntity);
        return clienteGuardado.toDomainModel();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return jpaClienteRepository.findById(id).map(ClienteEntity::toDomainModel);
    }

    @Override
    public List<Cliente> findAll() {
        return jpaClienteRepository.findAll().stream()
                .map(ClienteEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> update(Long id, Cliente cliente) {
        if(jpaClienteRepository.existsById(cliente.getId())){
            ClienteEntity taskEntity = ClienteEntity.fromDomainModel(cliente);
            ClienteEntity updateTaskEntity =   jpaClienteRepository.save(taskEntity);
            return Optional.of(updateTaskEntity.toDomainModel());
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaClienteRepository.existsById(id)){
            jpaClienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
