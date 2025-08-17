package org.unc.hexagonal.msvc_productos.infraestructure.controllers;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.unc.hexagonal.msvc_productos.application.services.ProductoService;
import org.unc.hexagonal.msvc_productos.domain.models.EstadoProducto;
import org.unc.hexagonal.msvc_productos.domain.models.Producto;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto created = productoService.crear(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        try {
            Producto p = productoService.buscarById(id);
            return ResponseEntity.ok(p);
        } catch (RuntimeException ex) { // la usecase lanza RuntimeException si no existe
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto data) {
        try {
            Producto updated = productoService.actualizar(id, data);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            boolean ok = productoService.eliminar(id);
            return ok ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    // extras
    @PostMapping("/{id}/almacen/aumentar")
    public ResponseEntity<Producto> aumentar(@PathVariable Long id, @RequestParam int cantidad) {
        return ResponseEntity.ok(productoService.aumentarAlmacen(id, cantidad));
    }

    @PostMapping("/{id}/tienda/disminuir")
    public ResponseEntity<Producto> disminuir(@PathVariable Long id, @RequestParam int cantidad) {
        return ResponseEntity.ok(productoService.disminuirTienda(id, cantidad));
    }

    @PostMapping("/{id}/transferir")
    public ResponseEntity<Producto> transferir(@PathVariable Long id, @RequestParam int cantidad) {
        return ResponseEntity.ok(productoService.transferir(id, cantidad));
    }

    @PatchMapping("/{id}/precio")
    public ResponseEntity<Producto> precio(@PathVariable Long id, @RequestParam double precio) {
        if (precio <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Precio inválido");
        }
        return ResponseEntity.ok(productoService.actualizarPrecio(id, precio));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Producto> estado(@PathVariable Long id, @RequestParam EstadoProducto estado) {
        if (estado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado inválido");
        }
        return ResponseEntity.ok(productoService.actualizarEstado(id, estado));
    }
}