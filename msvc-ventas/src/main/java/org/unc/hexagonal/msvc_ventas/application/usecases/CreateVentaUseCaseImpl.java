package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.CreateVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;

public class CreateVentaUseCaseImpl implements CreateVentaUseCase {

    private  final VentaRepositoryPort ventaRepositoryPort;

    public CreateVentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
    }

    @Override
    public Venta createVenta(Venta venta){
        return ventaRepositoryPort.createVenta(venta);
    }
}