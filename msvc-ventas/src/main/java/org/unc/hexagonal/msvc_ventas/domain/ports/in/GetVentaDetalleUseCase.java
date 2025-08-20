package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.application.dto.VentaDetalleResponse;

import java.util.List;

public interface GetVentaDetalleUseCase {
    VentaDetalleResponse getVentaDetalle(Long ventaId);
    List<VentaDetalleResponse> getVentasDetalle();


}