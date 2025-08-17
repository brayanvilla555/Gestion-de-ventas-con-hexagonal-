package org.unc.hexagonal.msvc_productos.infraestructure.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.unc.hexagonal.msvc_productos.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;

import java.time.LocalDateTime;

@Entity
@Table(name="productos")
@EntityListeners(AuditingEntityListener.class)
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private Double precio;
    private String imagen;
    private Integer stockTienda;
    private Integer stockAlmacen;

    @Enumerated(EnumType.STRING)
    private EstadoProducto estado;

    @CreatedDate
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    private LocalDateTime fechaActualizacion;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, Integer stockTienda, LocalDateTime fechaActualizacion, String categoria, String nombre, Double precio, String imagen, Integer stockAlmacen, EstadoProducto estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.stockTienda = stockTienda;
        this.fechaActualizacion = fechaActualizacion;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.stockAlmacen = stockAlmacen;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }


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
