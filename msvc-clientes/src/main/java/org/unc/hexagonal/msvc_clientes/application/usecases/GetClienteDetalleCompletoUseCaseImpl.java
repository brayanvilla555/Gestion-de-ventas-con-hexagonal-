package org.unc.hexagonal.msvc_clientes.application.usecases;

import org.unc.hexagonal.msvc_clientes.application.dto.ClienteVentaResponseDto;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.GetClienteDetalleCompletoUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ClienteRepositoryPort;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.util.List;

public class GetClienteDetalleCompletoUseCaseImpl implements GetClienteDetalleCompletoUseCase {

    private final ClienteRepositoryPort clienteRepositoryPort;
    private final ExternalServicePort externalServicePort;

    public GetClienteDetalleCompletoUseCaseImpl(ClienteRepositoryPort clienteRepositoryPort, ExternalServicePort externalServicePort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
        this.externalServicePort = externalServicePort;
    }


    @Override
    public ClienteVentaResponseDto ejecutar(Long clienteId) {
        Cliente cliente = clienteRepositoryPort.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado: " + clienteId));

        // Si quieres tolerancia a fallos del MS Ventas, captura la excepción y devuelve lista vacía.
        List<Venta> ventas = externalServicePort.getVentasCliente(clienteId);

        return new ClienteVentaResponseDto(cliente, ventas);
    }
}