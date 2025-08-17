package org.unc.hexagonal.msvc_ventas.infrastructure.mapper;

import org.unc.hexagonal.msvc_ventas.domain.models.Venta;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.VentaEntity;

import java.util.List;

public class VentaMapper {
    public static VentaEntity toVentaEntity(Venta venta){
        if(venta == null){
            throw new IllegalArgumentException("Venta no puede ser null");
        }
        return VentaEntity.builder()
                .fechaVenta(venta.getFechaVenta())
                .direccion(
                        DireccionEntregaMapper.toDireccionEntregaEmbeddable(venta.getDireccion())
                )
                .clienteId(venta.getClienteId())
                .itemsVenta(
                        ItemVentaMapper.toListItemVentaEntity(venta.getItemsVenta())
                )
                .estado(venta.getEstado())
                .total(venta.getTotal())
                .createdAt(venta.getCreatedAt())
                .updatedAt(venta.getUpdatedAt())
                .build();
    }

    public static Venta toVenta(VentaEntity ventaEntity){
        if(ventaEntity == null){
            throw new IllegalArgumentException("VentaEntity no puede ser null");
        }
        return new Venta(
                ventaEntity.getId(),
                ventaEntity.getFechaVenta(),
                DireccionEntregaMapper.toDireccionEntrega(ventaEntity.getDireccion()),
                ventaEntity.getClienteId(),
                ItemVentaMapper.toListItemVenta(ventaEntity.getItemsVenta()),
                ventaEntity.getEstado(),
                ventaEntity.getTotal(),
                ventaEntity.getCreatedAt(),
                ventaEntity.getUpdatedAt()
        );
    }

    public static List<Venta> toListVenta(List<VentaEntity> listVentaEntity) {
        if(listVentaEntity == null){
            throw new IllegalArgumentException("ListVentaEntity no puede ser null");
        }
        return listVentaEntity.stream()
                .map(VentaMapper::toVenta)
                .toList();
    }
}
