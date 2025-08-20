package org.unc.hexagonal.msvc_ventas.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto.ClienteDto;

@FeignClient(
        name = "msvc-clientes",
        url = "http://localhost:8090/api/cliente"
)
public interface ClienteFeignClient {
    @GetMapping("/{id}")
    ClienteDto getCliente(@PathVariable("id") Long id);
}