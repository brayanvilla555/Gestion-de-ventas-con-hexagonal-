package org.unc.hexagonal.msvc_ventas.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto.ClienteDto;

@FeignClient(
        name = "msvc-clientes",
        url = "http://localhost:8090/clientes"
)
public interface ClienteFeignClient {
    @GetMapping("/buscar/{id}")
    ClienteDto getCliente(@PathVariable("id") Long id);
}