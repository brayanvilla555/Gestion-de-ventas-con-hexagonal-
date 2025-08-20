package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetInformacionAdicionalVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;

public class GetInformacionAdicionalVentaUseCaseImpl  implements GetInformacionAdicionalVentaUseCase {

    private  final ExternalServicePort externalServicePort;

    public GetInformacionAdicionalVentaUseCaseImpl (ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public Cliente getClienteVentaInfo(Long id) {
        return externalServicePort.getClienteById(id);
    }

    @Override
    public Producto getProductoVentaInfo(Long id) {
        return externalServicePort.getProductoById(id);
    }
}
