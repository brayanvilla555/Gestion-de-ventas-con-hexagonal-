package org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.unc.hexagonal.msvc_clientes.domain.views.DireccionEntrega;


@Getter
@Setter
public class DireccionEntregaDto {
    private String referencia;
    private String calle;
    private String ciudad;
    private String departamento;
    private String codigoPostal;

    public DireccionEntrega toDomainModel(){
        return new DireccionEntrega(referencia, calle,ciudad,departamento,codigoPostal);
    }
}