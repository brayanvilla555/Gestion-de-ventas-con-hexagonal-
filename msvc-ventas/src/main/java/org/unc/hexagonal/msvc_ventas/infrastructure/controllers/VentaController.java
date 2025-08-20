package org.unc.hexagonal.msvc_ventas.infrastructure.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.unc.hexagonal.msvc_ventas.application.dto.VentaDetalleResponse;
import org.unc.hexagonal.msvc_ventas.application.services.VentaService;
import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.domain.ports.in.GetVentaDetalleUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;
    private final GetVentaDetalleUseCase getVentaDetalleUseCase;

    @PostMapping
    public ResponseEntity<Venta> createVenta(
            @RequestBody Venta venta
    ){
        Venta ventaCreated = ventaService.createVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ventaCreated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVenta(
            @PathVariable Long id
    ){
        boolean deleted = ventaService.deleteVenta(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(deleted);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVenta(@PathVariable Long id) {
        Venta venta = ventaService.getVenta(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe una venta con el id: " + id
                ));
        return ResponseEntity.ok(venta);
    }


    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas(){
        List<Venta> listVentas = ventaService.getAllVentas();
        return ResponseEntity.ok(listVentas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(
            @PathVariable Long id,
            @RequestBody Venta venta
    ){
        Venta ventaUpdated = ventaService.updateVenta(id,venta).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe una venta con el id: " + id + " para actualizar"
                )
        );
        return ResponseEntity.ok(ventaUpdated);
    }


    @GetMapping("venta-detalle-completo/{id-venta}")
    public ResponseEntity<VentaDetalleResponse> getVentaDetalle(
            @PathVariable(name = "id-venta") Long id
    ) {
        return ResponseEntity.ok(getVentaDetalleUseCase.getVentaDetalle(id));
    }

    @GetMapping("ventas-detalle-completo")
    public ResponseEntity<List<VentaDetalleResponse>> getVentasDetalle() {
        return ResponseEntity.ok(getVentaDetalleUseCase.getVentasDetalle());
    }
}
