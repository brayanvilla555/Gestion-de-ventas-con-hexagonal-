package org.unc.hexagonal.msvc_productos.application.usecases;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.unc.hexagonal.msvc_productos.application.exceptions.BusinessException;
import org.unc.hexagonal.msvc_productos.application.exceptions.NotFoundException;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.in.StockOperacionesUseCase;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

import java.util.Optional;

public class StockOperacionesUseCaseImpl  implements StockOperacionesUseCase {
   private final ProductoRepositoryPort productoRepositoryPort;

    public StockOperacionesUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }

    @Override
    public Producto aumentarAlmacen(Long id, int cantidad) {
        Producto p = productoRepositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
        try {
            p.aumentarStockAlmacen(cantidad);
        } catch (IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
        return productoRepositoryPort.save(p);
    }

    @Override
    public Producto disminuirTienda(Long id, int cantidad){
        Producto p = productoRepositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
        try {
            p.disminuirStockTienda(cantidad);
        } catch (IllegalArgumentException e) {
            throw new BusinessException(e.getMessage()); // → 400 por el advice
        }
        return productoRepositoryPort.save(p);
    }

    @Override
    public Producto transferir(Long id, int cantidad) {
        Producto p = productoRepositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
        try {
            p.transferirStock(cantidad);
        } catch (IllegalArgumentException e) {
            throw new BusinessException(e.getMessage());
        }
        return productoRepositoryPort.save(p);
    }
}
