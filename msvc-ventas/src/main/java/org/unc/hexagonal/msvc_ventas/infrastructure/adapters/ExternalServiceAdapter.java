package org.unc.hexagonal.msvc_ventas.infrastructure.adapters;

import lombok.*;
import org.unc.hexagonal.msvc_ventas.domain.models.Cliente;
import org.unc.hexagonal.msvc_ventas.domain.models.Producto;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.ClienteFeignClient;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.ProductoFeignClient;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto.ClienteDto;
import org.unc.hexagonal.msvc_ventas.infrastructure.clients.dto.ProductoDto;

@RequiredArgsConstructor
public class ExternalServiceAdapter implements ExternalServicePort {

    private final ClienteFeignClient clienteFeignClient;
    private final ProductoFeignClient productoFeignClient;

    @Override
    public Cliente getClienteById(Long clienteId) {
        ClienteDto clienteDto = clienteFeignClient.getCliente(clienteId);
        return new Cliente(
                clienteDto.getId(),
                clienteDto.getNombre(),
                clienteDto.getApellido(),
                clienteDto.getCorreo(),
                clienteDto.getTelefono(),
                clienteDto.getNumeroIdentificacion(),
                clienteDto.getEstado(),
                clienteDto.getCreatedAt(),
                clienteDto.getUpdatedAt()
        );
    }

    @Override
    public Producto getProductoById(Long productoId) {
        ProductoDto productoDto = productoFeignClient.getProducto(productoId);
        return new Producto(
                productoDto.getId(),
                productoDto.getNombre(),
                productoDto.getCategoria(),
                productoDto.getPrecio(),
                productoDto.getImagen(),
                productoDto.getStockTienda(),
                productoDto.getStockAlmacen()
        );
    }
}
