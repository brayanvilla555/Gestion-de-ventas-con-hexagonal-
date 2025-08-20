package org.unc.hexagonal.msvc_clientes.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.unc.hexagonal.msvc_clientes.application.services.ClienteService;
import org.unc.hexagonal.msvc_clientes.application.usecases.*;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.GetClienteDetalleCompletoUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.GetInformacionAdicionalClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_clientes.infraestructure.adapters.ExternalServiceAdapter;
import org.unc.hexagonal.msvc_clientes.infraestructure.clients.VentasFeignClient;
import org.unc.hexagonal.msvc_clientes.infraestructure.repositories.JpaClienteRepository;
import org.unc.hexagonal.msvc_clientes.infraestructure.repositories.JpaClienteRepositoryAdapter;

import java.lang.ref.Cleaner;

@Configuration
@EnableJpaAuditing
public class ApplicationConfig {

   @Bean
    public ClienteService clienteService(ClienteRepositoryPort clienteRepositoryPort, GetInformacionAdicionalClienteUseCase getInformacionAdicionalClienteUseCase, GetClienteDetalleCompletoUseCase getClienteDetalleCompletoUseCase){
        return new ClienteService(
                new CrearClienteUseCaseImpl(clienteRepositoryPort),
                new ListClienteUseCaseImpl(clienteRepositoryPort),
                new ActualizarClienteUseCaseImpl(clienteRepositoryPort),
                new EliminarClienteUseCaseImpl(clienteRepositoryPort),
                getInformacionAdicionalClienteUseCase,
                getClienteDetalleCompletoUseCase
        );
    }

    @Bean
    public ClienteRepositoryPort clienteRepositoryPort(JpaClienteRepositoryAdapter jpaClienteRepositoryAdapter){
        return jpaClienteRepositoryAdapter;
    }

    @Bean
    public  GetInformacionAdicionalClienteUseCase getInformacionAdicionalClienteUseCase(ExternalServicePort externalServicePort){
        return new GetInformacionAdicionalClienteUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(VentasFeignClient ventasFeignClient){
        return new ExternalServiceAdapter(ventasFeignClient);
    }


    @Bean
    public GetClienteDetalleCompletoUseCase getClienteDetalleCompletoUseCase(ClienteRepositoryPort clienteRepositoryPort,
                                                                             ExternalServicePort externalServicePort) {
        return new GetClienteDetalleCompletoUseCaseImpl(clienteRepositoryPort, externalServicePort);
    }



}