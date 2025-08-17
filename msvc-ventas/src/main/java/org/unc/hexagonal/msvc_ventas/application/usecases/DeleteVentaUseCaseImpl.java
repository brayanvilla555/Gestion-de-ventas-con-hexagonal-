package org.unc.hexagonal.msvc_ventas.application.usecases;


import org.unc.hexagonal.msvc_ventas.domain.ports.in.DeleteVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;

public class DeleteVentaUseCaseImpl implements DeleteVentaUseCase {

    private  final VentaRepositoryPort ventaRepositoryPort;

    public DeleteVentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
    }

    @Override
    public boolean deleteVenta(Long id){
        return ventaRepositoryPort.deleteVenta(id);
    }
}