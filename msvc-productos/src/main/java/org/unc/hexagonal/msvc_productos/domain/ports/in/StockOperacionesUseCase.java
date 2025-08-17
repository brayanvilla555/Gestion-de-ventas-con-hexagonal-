package org.unc.hexagonal.msvc_productos.domain.ports.in;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;

public interface StockOperacionesUseCase {
    Producto aumentarAlmacen(Long id, int cantidad);
    Producto disminuirTienda(Long id, int cantidad);
    Producto transferir(Long id, int cantidad) ;
}
