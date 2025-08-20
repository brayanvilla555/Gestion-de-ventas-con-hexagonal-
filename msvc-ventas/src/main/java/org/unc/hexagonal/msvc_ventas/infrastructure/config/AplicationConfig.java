package org.unc.hexagonal.msvc_ventas.infrastructure.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.unc.hexagonal.msvc_ventas.application.services.VentaService;
import org.unc.hexagonal.msvc_ventas.application.usecases.*;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetInformacionAdicionalVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetVentaDetalleUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;
import org.unc.hexagonal.msvc_ventas.infrastructure.adapters.ExternalServiceAdapter;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.ClienteFeignClient;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.ProductoFeignClient;
import org.unc.hexagonal.msvc_ventas.infrastructure.repositories.JpaVentaRepositoryAdapter;

@Configuration
public class AplicationConfig {

    @Bean
    public VentaService ventaService(
            VentaRepositoryPort ventaRepositoryPort,
            GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase
    ){
        return new VentaService(
                new CreateVentaUseCaseImpl(ventaRepositoryPort),
                new RetriveVentaUseCaseImpl(ventaRepositoryPort),
                new UpdateVentaUseCaseImpl(ventaRepositoryPort),
                new DeleteVentaUseCaseImpl(ventaRepositoryPort),
                getInformacionAdicionalVentaUseCase
        );
    }

    @Bean
    public VentaRepositoryPort ventaRepositoryPort(
            JpaVentaRepositoryAdapter jpaVentaRepositoryAdapter
    ){
        return jpaVentaRepositoryAdapter;
    }

    @Bean
    @Qualifier("getInformacionAdicionalVentaUseCase")
    public GetInformacionAdicionalVentaUseCaseImpl getAditionalVentaUseCase(
            ExternalServicePort externalServicePort
    ){
        return new GetInformacionAdicionalVentaUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort(
            ClienteFeignClient clienteFeignClient,
            ProductoFeignClient productoFeignClient
    ){
        return new ExternalServiceAdapter(clienteFeignClient, productoFeignClient);
    }

    @Bean
    public GetVentaDetalleUseCase getVentaDetalleUseCase(VentaRepositoryPort ventaRepositoryPort,
            @Qualifier("getInformacionAdicionalVentaUseCase") GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase
    ) {
        return new GetVentaDetalleUseCaseImpl(ventaRepositoryPort, getInformacionAdicionalVentaUseCase);
    }

}
