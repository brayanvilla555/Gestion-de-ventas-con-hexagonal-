package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.AditionalVentaInfo;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetAditionalVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;

public class GetClienteVentaUseCaseImpl implements GetAditionalVentaUseCase {

    private  final ExternalServicePort externalServicePort;

    public GetClienteVentaUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }


    @Override
    public AditionalVentaInfo getAditionalVentaInfo(Long id){
        return externalServicePort.getAditionalVentaInfo(id);
    }
}
