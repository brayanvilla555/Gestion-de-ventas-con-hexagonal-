package org.unc.hexagonal.msvc_ventas.domain.ports.out;

import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;

public interface ExternalServicePort {
    Cliente getClienteById(Long clienteId);
    Producto getProductoById(Long productoId);
}
