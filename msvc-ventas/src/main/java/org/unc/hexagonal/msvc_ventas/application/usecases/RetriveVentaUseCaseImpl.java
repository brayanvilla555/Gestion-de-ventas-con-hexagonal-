package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.RetriveVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetriveVentaUseCaseImpl implements RetriveVentaUseCase {

    private  final VentaRepositoryPort ventaRepositoryPort;

    public RetriveVentaUseCaseImpl(VentaRepositoryPort ventaRepositoryPort) {
        this.ventaRepositoryPort = ventaRepositoryPort;
    }

    @Override
    public Optional<Venta> getVenta(Long id){

        return ventaRepositoryPort.getVenta(id);
    }

    @Override
    public List<Venta> getAllVentas(){
        return ventaRepositoryPort.getAllVentas();
    }

    @Override
    public List<Venta> getVentaByClienteId(Long numero) {
        return ventaRepositoryPort.getVentaByClienteId(numero);
    }
}