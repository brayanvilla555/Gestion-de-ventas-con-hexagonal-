package org.unc.hexagonal.msvc_ventas.application.services;

import org.unc.hexagonal.msvc_ventas.domain.models.AditionalVentaInfo;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class VentaService implements CreateVentaUseCase, DeleteVentaUseCase, GetAditionalVentaUseCase, UpdateVentaUseCase, RetriveVentaUseCase {

    private final CreateVentaUseCase createVentaUseCase;
    private final DeleteVentaUseCase deleteVentaUseCase;
    private final GetAditionalVentaUseCase getAditionalVentaUseCase;
    private final UpdateVentaUseCase updateVentaUseCase;
    private final RetriveVentaUseCase retriveVentaUseCase;

    public VentaService(
            CreateVentaUseCase createVentaUseCase,
            RetriveVentaUseCase retriveVentaUseCase,
            UpdateVentaUseCase updateVentaUseCase,
            DeleteVentaUseCase deleteVentaUseCase,
            GetAditionalVentaUseCase getAditionalVentaUseCase
    ) {
        this.createVentaUseCase = createVentaUseCase;
        this.retriveVentaUseCase = retriveVentaUseCase;
        this.updateVentaUseCase = updateVentaUseCase;
        this.deleteVentaUseCase = deleteVentaUseCase;
        this.getAditionalVentaUseCase = getAditionalVentaUseCase;
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
    public AditionalVentaInfo getAditionalVentaInfo(Long id) {

        return getAditionalVentaUseCase.getAditionalVentaInfo(id);

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
    public Optional<Venta> updateVenta(Long id, Venta venta) {

        return updateVentaUseCase.updateVenta(id,venta);

    }
}
