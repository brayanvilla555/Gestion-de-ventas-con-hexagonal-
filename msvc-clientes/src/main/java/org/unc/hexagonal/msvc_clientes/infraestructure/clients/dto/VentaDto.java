package org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.unc.hexagonal.msvc_clientes.domain.views.EstadoVenta;
import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class VentaDto {
    private Long id;
    private LocalDateTime fechaVenta;
    private DireccionEntregaDto direccion;
    private List<ItemVentaDto> itemsVenta = new ArrayList<>();
    private EstadoVentaDto estado;
    private Double total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Venta toDomainModel(){
        return new Venta(id, fechaVenta, direccion.toDomainModel(),itemsVenta.stream().map(ItemVentaDto::todomainModel).collect(Collectors.toList()), EstadoVenta.valueOf(estado.name()), total, createdAt, updatedAt);
    }

}