package org.unc.hexagonal.msvc_clientes.domain.ports.in;


import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.util.List;

public interface GetInformacionAdicionalClienteUseCase {
    List<Venta> getListaVentas(Long idCliente);
}
