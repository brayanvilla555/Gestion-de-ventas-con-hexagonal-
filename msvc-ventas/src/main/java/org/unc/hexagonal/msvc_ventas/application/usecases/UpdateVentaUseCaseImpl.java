package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.UpdateVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;

import java.util.Optional;

public class UpdateVentaUseCaseImpl implements UpdateVentaUseCase {

    private  final VentaRepositoryPort ventaRepositoryPort;

    public UpdateVentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
    }

    @Override
    public Optional<Venta> updateVenta(Long id, Venta venta){
        return ventaRepositoryPort.updateVenta(id, venta);
    }
}