package org.unc.hexagonal.msvc_productos.infraestructure.mapper;

import org.unc.hexagonal.msvc_productos.domain.models.Producto;
import org.unc.hexagonal.msvc_productos.infraestructure.entities.ProductoEntity;

import java.util.List;

public class ProductoMapper {
    public static ProductoEntity toProductoEntity(Producto p){
        if (p == null) throw new IllegalArgumentException("Producto no puede ser null");
        ProductoEntity e = new ProductoEntity();
        e.setId(p.getId());
        e.setNombre(p.getNombre());
        e.setCategoria(p.getCategoria());
        e.setPrecio(p.getPrecio());
        e.setImagen(p.getImagen());
        e.setStockTienda(p.getStockTienda());
        e.setStockAlmacen(p.getStockAlmacen());
        e.setEstado(p.getEstado());
        return e;
    }

    public static Producto toProducto(ProductoEntity e){
        if (e == null) throw new IllegalArgumentException("ProductoEntity no puede ser null");

        Producto p = new Producto();
        p.setId(e.getId());
        p.setNombre(e.getNombre());
        p.setCategoria(e.getCategoria());
        p.setPrecio(e.getPrecio());
        p.setImagen(e.getImagen());
        p.setStockTienda(e.getStockTienda());
        p.setStockAlmacen(e.getStockAlmacen());
        p.setEstado(e.getEstado());
        return p;
    }

    public static List<Producto> toListProducto(List<ProductoEntity> listEntity){
        if (listEntity == null) throw new IllegalArgumentException("List<ProductoEntity> no puede ser null");
        return listEntity.stream().map(ProductoMapper::toProducto).toList();
    }
}
