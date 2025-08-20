package org.unc.hexagonal.msvc_productos.application.services;

import org.springframework.transaction.annotation.Transactional;
import org.unc.hexagonal.msvc_productos.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.domain.ports.in.*;
import org.unc.hexagonal.msvc_productos.domain.ports.out.ProductoRepositoryPort;

import java.util.List;

public class ProductoService implements ActualizarPrecioEstadoUseCase,ActualizarProductoUseCase, CrearProductoUseCase, EliminarProductoUseCase, ListProductoUseCase, StockOperacionesUseCase {

    private final CrearProductoUseCase crearProductoUseCase;
    private final ListProductoUseCase listProductoUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final StockOperacionesUseCase stockOperacionesUseCase;
    private final ActualizarPrecioEstadoUseCase actualizarPrecioEstadoUseCase;

    public ProductoService(CrearProductoUseCase crearProductoUseCase, ListProductoUseCase listProductoUseCase, ActualizarProductoUseCase actualizarProductoUseCase, EliminarProductoUseCase eliminarProductoUseCase, StockOperacionesUseCase stockOperacionesUseCase, ActualizarPrecioEstadoUseCase actualizarPrecioEstadoUseCase) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.listProductoUseCase = listProductoUseCase;
        this.actualizarProductoUseCase = actualizarProductoUseCase;
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.stockOperacionesUseCase = stockOperacionesUseCase;
        this.actualizarPrecioEstadoUseCase = actualizarPrecioEstadoUseCase;
    }




    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return listProductoUseCase.listar();
    }

    @Override
    public Producto crear(Producto producto) {
        return crearProductoUseCase.crear(producto);
    }
    @Override
    public Producto actualizar(Long id, Producto producto) {
        return actualizarProductoUseCase.actualizar(id, producto);
    }
    @Override
    public boolean eliminar(Long id) {
      return  eliminarProductoUseCase.eliminar(id);

    }
    @Override
    @Transactional(readOnly = true)
    public Producto buscarById(Long id) {
        return listProductoUseCase.buscarById(id);
    }

    @Override
    public Producto aumentarAlmacen(Long id, int cantidad) {
        return stockOperacionesUseCase.aumentarAlmacen(id,cantidad);
    }

    @Override
    public Producto disminuirTienda(Long id, int cantidad) {
        return stockOperacionesUseCase.disminuirTienda(id,cantidad);
    }

    @Override
    public Producto transferir(Long id, int cantidad) {
        return stockOperacionesUseCase.transferir(id,cantidad);
    }
    @Override
    public Producto actualizarEstado(Long id, EstadoProducto estado) {
        return actualizarPrecioEstadoUseCase.actualizarEstado(id,estado);
    }

    @Override
    public Producto actualizarPrecio(Long id, double precio) {
        return actualizarPrecioEstadoUseCase.actualizarPrecio(id, precio);
    }


}
