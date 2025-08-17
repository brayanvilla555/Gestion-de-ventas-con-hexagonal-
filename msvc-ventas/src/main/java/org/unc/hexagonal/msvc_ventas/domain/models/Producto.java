package org.unc.hexagonal.msvc_ventas.domain.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Producto {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private String imagen;
    private Integer stockTienda;
    private Integer stockAlmacen;
    private EstadoProducto estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public Producto(Long id, String nombre, String categoria, Double precio, String imagen, Integer stockTienda, Integer stockAlmacen, EstadoProducto estado, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.imagen = imagen;
        this.stockTienda = stockTienda;
        this.stockAlmacen = stockAlmacen;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }
    // ===== Reglas de negocio (tus métodos) =====
    public void aumentarStockAlmacen(int cantidad) {
        validarPositivo(cantidad);
        this.stockAlmacen = (stockAlmacen == null ? 0 : stockAlmacen) + cantidad;
    }
    public void disminuirStockTienda(int cantidad) {
        validarPositivo(cantidad);
        int actual = stockTienda == null ? 0 : stockTienda;
        if (actual < cantidad) throw new IllegalArgumentException("Stock tienda insuficiente.");
        this.stockTienda = actual - cantidad;
    }
    public void transferirStock(int cantidad) {
        validarPositivo(cantidad);
        int almacen = stockAlmacen == null ? 0 : stockAlmacen;
        if (almacen < cantidad) throw new IllegalArgumentException("Stock almacén insuficiente.");
        this.stockAlmacen = almacen - cantidad;
        this.stockTienda = (stockTienda == null ? 0 : stockTienda) + cantidad;
    }
    public void actualizarEstado(EstadoProducto nuevo) { this.estado = Objects.requireNonNull(nuevo); }
    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio <= 0) throw new IllegalArgumentException("Precio inválido");
        this.precio = nuevoPrecio;
    }
    private void validarPositivo(int v){ if (v <= 0) throw new IllegalArgumentException("Cantidad inválida"); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getStockTienda() {
        return stockTienda;
    }

    public void setStockTienda(Integer stockTienda) {
        this.stockTienda = stockTienda;
    }

    public Integer getStockAlmacen() {
        return stockAlmacen;
    }

    public void setStockAlmacen(Integer stockAlmacen) {
        this.stockAlmacen = stockAlmacen;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
