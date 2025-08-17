package org.unc.hexagonal.msvc_ventas.infrastructure.mapper;

import org.unc.hexagonal.msvc_ventas.domain.models.ItemVenta;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.ItemVentaEntity;

import java.util.List;

public class ItemVentaMapper {
    public static ItemVentaEntity toItemVentaEntity(ItemVenta itemVenta){
        if(itemVenta == null){
            throw new IllegalArgumentException("ItemVenta no puede ser null");
        }
        return ItemVentaEntity.builder()
                .productoId(itemVenta.getProductoId())
                .cantidad(itemVenta.getCantidad())
                .precio(itemVenta.getPrecio())
                .subTotal(itemVenta.getSubTotal())
                .build();
    }
    public static List<ItemVentaEntity> toListItemVentaEntity(List<ItemVenta> itemVenta){
        if(itemVenta == null){
            throw new IllegalArgumentException("ItemVenta no puede ser null");
        }
        return itemVenta.stream()
                .map(ItemVentaMapper::toItemVentaEntity)
                .toList();
    }

    public static ItemVenta toItemVenta(ItemVentaEntity itemVentaEntity){
        if(itemVentaEntity == null){
            throw new IllegalArgumentException("ItemVentaEntity no puede ser null");
        }
        return new ItemVenta(
                itemVentaEntity.getId(),
                itemVentaEntity.getProductoId(),
                itemVentaEntity.getCantidad(),
                itemVentaEntity.getPrecio(),
                itemVentaEntity.getSubTotal(),
                null
                //VentaMapper.toVenta(itemVentaEntity.getVenta())
        );
    }

    public static List<ItemVenta> toListItemVenta(List<ItemVentaEntity> itemsVenta) {
        if(itemsVenta == null){
            throw new IllegalArgumentException("ItemVenta no puede ser null");
        }
        return itemsVenta.stream()
                .map(ItemVentaMapper::toItemVenta)
                .toList();
    }
}
