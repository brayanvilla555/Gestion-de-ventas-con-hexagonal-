package org.unc.hexagonal.msvc_ventas.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.unc.hexagonal.msvc_ventas.application.services.VentaService;
import org.unc.hexagonal.msvc_ventas.application.usecases.*;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetAditionalVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;
import org.unc.hexagonal.msvc_ventas.infrastructure.adapters.ExternalServiceAdapter;
import org.unc.hexagonal.msvc_ventas.infrastructure.repositories.JpaVentaRepositoryAdapter;

@Configuration
public class AplicationConfig {
    @Bean
    public VentaService ventaService(
            VentaRepositoryPort ventaRepositoryPort,
            GetAditionalVentaUseCase getAditionalVentaUseCase
    ){
        return new VentaService(
                new CreateVentaUseCaseImpl(ventaRepositoryPort),
                new RetriveVentaUseCaseImpl(ventaRepositoryPort),
                new UpdateVentaUseCaseImpl(ventaRepositoryPort),
                new DeleteVentaUseCaseImpl(ventaRepositoryPort),
                getAditionalVentaUseCase
        );
    }

    @Bean
    public VentaRepositoryPort ventaRepositoryPort(
            JpaVentaRepositoryAdapter jpaVentaRepositoryAdapter
    ){
        return jpaVentaRepositoryAdapter;
    }

    @Bean
    public GetAditionalVentaUseCase getAditionalVentaUseCase(
            ExternalServicePort externalServicePort
    ){
        return new GetClienteVentaUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }

}
