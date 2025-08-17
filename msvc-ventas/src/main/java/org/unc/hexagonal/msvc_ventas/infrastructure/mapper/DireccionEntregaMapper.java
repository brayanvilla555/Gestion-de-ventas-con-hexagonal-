package org.unc.hexagonal.msvc_ventas.infrastructure.mapper;

import org.unc.hexagonal.msvc_ventas.domain.models.DireccionEntrega;
import org.unc.hexagonal.msvc_ventas.infrastructure.entities.DireccionEntregaEmbeddable;

public class DireccionEntregaMapper {
    public static DireccionEntregaEmbeddable toDireccionEntregaEmbeddable(DireccionEntrega direccionEntrega){
        if(direccionEntrega == null){
            throw new IllegalArgumentException("DireccionEntrega no puede ser null");
        }
        return DireccionEntregaEmbeddable.builder()
                .referencia(direccionEntrega.getReferencia())
                .calle(direccionEntrega.getCalle())
                .ciudad(direccionEntrega.getCiudad())
                .departamento(direccionEntrega.getDepartamento())
                .codigoPostal(direccionEntrega.getCodigoPostal())
                .build();
    }

    public static DireccionEntrega toDireccionEntrega(DireccionEntregaEmbeddable direccionEntregaEmbeddable){
        if(direccionEntregaEmbeddable == null){
            throw new IllegalArgumentException("DireccionEntregaEmbeddable no puede ser null");
        }
        return new DireccionEntrega(
                direccionEntregaEmbeddable.getReferencia(),
                direccionEntregaEmbeddable.getCalle(),
                direccionEntregaEmbeddable.getCiudad(),
                direccionEntregaEmbeddable.getDepartamento(),
                direccionEntregaEmbeddable.getCodigoPostal()
        );
    }
}
