package org.unc.hexagonal.msvc_ventas.application.usecases;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.unc.hexagonal.msvc_ventas.application.dto.VentaDetalleResponse;
import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetInformacionAdicionalVentaUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetVentaDetalleUseCase;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.VentaRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class GetVentaDetalleUseCaseImpl implements GetVentaDetalleUseCase {

    private final VentaRepositoryPort ventaRepositoryPort;
    private final GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase;

    public GetVentaDetalleUseCaseImpl(
            VentaRepositoryPort ventaRepositoryPort,
            GetInformacionAdicionalVentaUseCase getInformacionAdicionalVentaUseCase
    ) {
        this.ventaRepositoryPort = ventaRepositoryPort;
        this.getInformacionAdicionalVentaUseCase = getInformacionAdicionalVentaUseCase;
    }

    @Override
    public VentaDetalleResponse getVentaDetalle(Long ventaId) {
        Venta venta = ventaRepositoryPort.getVenta(ventaId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe una venta con el id: " + ventaId
                ));

        Cliente cliente = getInformacionAdicionalVentaUseCase.getClienteVentaInfo(venta.getClienteId());

        List<Producto> productos = new ArrayList<>();
        venta.getItemsVenta().forEach(itemVenta -> {
            Producto producto = getInformacionAdicionalVentaUseCase.getProductoVentaInfo(itemVenta.getProductoId());
            productos.add(producto);
        });

        return new VentaDetalleResponse(venta, cliente, productos);
    }

    @Override
    public List<VentaDetalleResponse> getVentasDetalle() {
        List<Venta> ventas = ventaRepositoryPort.getAllVentas();

        List<VentaDetalleResponse> detalles = new ArrayList<>();

        for (Venta venta : ventas) {
            Cliente cliente = getInformacionAdicionalVentaUseCase.getClienteVentaInfo(venta.getClienteId());

            List<Producto> productos = new ArrayList<>();
            venta.getItemsVenta().forEach(itemVenta -> {
                Producto producto = getInformacionAdicionalVentaUseCase.getProductoVentaInfo(itemVenta.getProductoId());
                productos.add(producto);
            });

            detalles.add(new VentaDetalleResponse(venta, cliente, productos));
        }

        return detalles;
    }
}