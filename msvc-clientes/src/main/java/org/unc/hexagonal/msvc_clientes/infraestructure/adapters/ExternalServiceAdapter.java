package org.unc.hexagonal.msvc_clientes.infraestructure.adapters;

import org.unc.hexagonal.msvc_clientes.domain.views.Venta;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_clientes.infraestructure.clients.VentasFeignClient;
import org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto.VentaDto;

import java.util.List;
import java.util.stream.Collectors;

public class ExternalServiceAdapter implements ExternalServicePort {
    private final VentasFeignClient ventasFeignClient;

    public ExternalServiceAdapter(VentasFeignClient ventasFeignClient) {
        this.ventasFeignClient = ventasFeignClient;
    }


    @Override
    public List<Venta> getVentasCliente(Long clienteId) {
        List<VentaDto> clienteDto = ventasFeignClient.getVenta(clienteId);
        return clienteDto.stream().map(VentaDto::toDomainModel).collect(Collectors.toList());

    }
}
