package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.Producto;

public interface StockOperacionesUseCase {
    Producto aumentarAlmacen(Long id, int cantidad);
    Producto disminuirTienda(Long id, int cantidad);
    Producto transferir(Long id, int cantidad);
}
