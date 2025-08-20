package org.unc.hexagonal.msvc_ventas.application.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements CreateVentaUseCase, DeleteVentaUseCase, GetInformacionAdicionalVentaUseCase, UpdateVentaUseCase, RetriveVentaUseCase {

    private final CreateVentaUseCase createVentaUseCase;
    private final DeleteVentaUseCase deleteVentaUseCase;
    private final GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase;
    private final UpdateVentaUseCase updateVentaUseCase;
    private final RetriveVentaUseCase retriveVentaUseCase;

    public VentaService(
            CreateVentaUseCase createVentaUseCase,
            RetriveVentaUseCase retriveVentaUseCase,
            UpdateVentaUseCase updateVentaUseCase,
            DeleteVentaUseCase deleteVentaUseCase,
            @Qualifier("getInformacionAdicionalVentaUseCase") GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase
    ) {
        this.createVentaUseCase = createVentaUseCase;
        this.retriveVentaUseCase = retriveVentaUseCase;
        this.updateVentaUseCase = updateVentaUseCase;
        this.deleteVentaUseCase = deleteVentaUseCase;
        this.getInformacionAdicionalVentaUseCase = getInformacionAdicionalVentaUseCase;
    }


    @Override
    public Venta createVenta(Venta venta) {

        Venta ventaSave = createVentaUseCase.createVenta(venta);
        return ventaSave;

    }

    @Override
    public boolean deleteVenta(Long id) {

        return deleteVentaUseCase.deleteVenta(id);

    }

    @Override
    public Optional<Venta> getVenta(Long id) {

        return retriveVentaUseCase.getVenta(id);

    }

    @Override
    public List<Venta> getAllVentas() {

        return retriveVentaUseCase.getAllVentas();

    }

    @Override
    public List<Venta> getVentaByClienteId(Long clienteId) {
        return retriveVentaUseCase.getVentaByClienteId(clienteId);
    }

    @Override
    public Optional<Venta> updateVenta(Long id, Venta venta) {

        return updateVentaUseCase.updateVenta(id,venta);

    }


    @Override
    public Cliente getClienteVentaInfo(Long id) {
        return getInformacionAdicionalVentaUseCase.getClienteVentaInfo(id);
    }

    @Override
    public Producto getProductoVentaInfo(Long id) {
        return getInformacionAdicionalVentaUseCase.getProductoVentaInfo(id);
    }
}
