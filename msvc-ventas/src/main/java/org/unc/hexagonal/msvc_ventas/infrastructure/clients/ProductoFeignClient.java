package org.unc.hexagonal.msvc_ventas.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto.ProductoDto;

@FeignClient(
        name = "msvc-productos",
        url = "http://localhost:8070/api/producto"
)
public interface ProductoFeignClient {
    @GetMapping("/{id}")
    ProductoDto getProducto(@PathVariable("id") Long id);
}