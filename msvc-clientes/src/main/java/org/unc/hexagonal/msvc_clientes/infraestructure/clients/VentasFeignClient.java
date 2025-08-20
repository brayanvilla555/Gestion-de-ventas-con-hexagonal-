package org.unc.hexagonal.msvc_clientes.infraestructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto.VentaDto;

import java.util.List;

@FeignClient(
        name = "msvc-ventas",
        url = "http://localhost:8091/api/ventas"
)
public interface VentasFeignClient {
    @GetMapping("/ventascliente/{idcliente}")
    List<VentaDto> getVenta(@PathVariable("idcliente") Long id);
}