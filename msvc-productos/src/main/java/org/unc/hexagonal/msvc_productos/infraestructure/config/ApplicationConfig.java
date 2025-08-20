package org.unc.hexagonal.msvc_productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.unc.hexagonal.msvc_productos.application.services.ProductoService;
import org.unc.hexagonal.msvc_productos.application.usecases.*;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;
import org.unc.hexagonal.msvc_productos.infraestructure.repositories.JpaProductoRepository;
import org.unc.hexagonal.msvc_productos.infraestructure.repositories.JpaProductoRepositoryAdapter;

@Configuration
@EnableJpaAuditing
public class ApplicationConfig {

    @Bean
    public ProductoRepositoryPort productoRepositoryPort(JpaProductoRepository jpaRepo){
        return new JpaProductoRepositoryAdapter(jpaRepo);
    }

    @Bean
    public ProductoService productoService(ProductoRepositoryPort repo){
        return new ProductoService(
                new CrearProductoUseCaseImpl(repo),
                new ListProductoUseCaseImpl(repo),
                new ActualizarProductoUseCaseImpl(repo),
                new EliminarProductoUseCaseImpl(repo),
                new StockOperacionesUseCaseImpl(repo),
                new ActualizarPrecioEstadoUseCaseImpl(repo)
        );
    }

}