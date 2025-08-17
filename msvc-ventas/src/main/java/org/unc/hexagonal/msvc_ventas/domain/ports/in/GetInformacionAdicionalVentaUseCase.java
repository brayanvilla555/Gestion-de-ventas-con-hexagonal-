package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;


public interface GetInformacionAdicionalVentaUseCase  {
    Cliente getClienteVentaInfo(Long id);
    Producto getProductoVentaInfo(Long id);
}
