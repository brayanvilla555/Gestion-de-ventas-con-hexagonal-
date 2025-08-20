package org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.unc.hexagonal.msvc_clientes.domain.views.ItemVenta;

@Getter
@Setter
public class ItemVentaDto {
    private Long id;
    private Long productoId;
    private Integer cantidad;
    private Double precio;
    private Double subTotal;


    public ItemVenta todomainModel(){
        return new ItemVenta(id, productoId, cantidad, precio, subTotal) ;
    }
}
