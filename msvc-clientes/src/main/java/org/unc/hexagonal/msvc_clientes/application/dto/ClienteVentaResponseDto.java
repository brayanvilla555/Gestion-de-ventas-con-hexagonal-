package org.unc.hexagonal.msvc_clientes.application.dto;

import lombok.*;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.util.List;


@Data
@NoArgsConstructor
public class ClienteVentaResponseDto {
    private Cliente cliente;
    private List<Venta> ventas;

    public ClienteVentaResponseDto(Cliente cliente, List<Venta> ventas) {
        this.cliente = cliente;
        this.ventas = ventas;
    }
}
