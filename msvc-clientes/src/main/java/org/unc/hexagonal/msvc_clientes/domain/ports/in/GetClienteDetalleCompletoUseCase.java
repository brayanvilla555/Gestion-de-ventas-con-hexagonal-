package org.unc.hexagonal.msvc_clientes.domain.ports.in;

import org.unc.hexagonal.msvc_clientes.application.dto.ClienteVentaResponseDto;

public interface GetClienteDetalleCompletoUseCase {
    ClienteVentaResponseDto ejecutar(Long clienteId);
}