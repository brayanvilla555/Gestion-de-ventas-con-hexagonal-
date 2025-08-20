package org.unc.hexagonal.msvc_ventas.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;

import java.util.List;

@Getter
@AllArgsConstructor
public class VentaDetalleResponse {
    private Venta venta;
    private Cliente cliente;
    private List<Producto> productos;
}