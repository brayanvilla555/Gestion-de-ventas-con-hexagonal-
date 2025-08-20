package org.unc.hexagonal.msvc_clientes.domain.ports.out;


import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.util.List;

public interface ExternalServicePort {
    List<Venta> getVentasCliente(Long clienteId);
}
