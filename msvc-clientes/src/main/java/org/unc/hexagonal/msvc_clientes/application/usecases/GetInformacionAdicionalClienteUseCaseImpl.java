package org.unc.hexagonal.msvc_clientes.application.usecases;


import org.unc.hexagonal.msvc_clientes.domain.views.Venta;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.GetInformacionAdicionalClienteUseCase;
import org.unc.hexagonal.msvc_clientes.domain.ports.out.ExternalServicePort;

import java.util.List;

public class GetInformacionAdicionalClienteUseCaseImpl implements GetInformacionAdicionalClienteUseCase {
    private  final ExternalServicePort externalServicePort;

    public GetInformacionAdicionalClienteUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }


    @Override
    public List<Venta> getListaVentas(Long idCliente) {
        return externalServicePort.getVentasCliente(idCliente);
    }
}
