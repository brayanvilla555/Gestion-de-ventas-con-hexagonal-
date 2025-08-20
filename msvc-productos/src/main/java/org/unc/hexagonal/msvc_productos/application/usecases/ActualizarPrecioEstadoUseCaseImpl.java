package org.unc.hexagonal.msvc_productos.application.usecases;

import org.unc.hexagonal.msvc_productos.application.exceptions.NotFoundException;
import org.unc.hexagonal.msvc_productos.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

public class ActualizarPrecioEstadoUseCaseImpl implements org.unc.hexagonal.msvc_productos.domain.ports.in.ActualizarPrecioEstadoUseCase {
  private final ProductoRepositoryPort productoRepositoryPort;

    public ActualizarPrecioEstadoUseCaseImpl(ProductoRepositoryPort productoRepositoryPort) {
        this.productoRepositoryPort = productoRepositoryPort;
    }


    @Override
    public Producto actualizarEstado(Long id, EstadoProducto estado) {
        Producto p = productoRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
        p.actualizarEstado(estado);
        return productoRepositoryPort.save(p);

    }

    @Override
    public Producto actualizarPrecio(Long id, double precio) {
        Producto p = productoRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
        p.actualizarPrecio(precio);
        return productoRepositoryPort.save(p);
    }
}
