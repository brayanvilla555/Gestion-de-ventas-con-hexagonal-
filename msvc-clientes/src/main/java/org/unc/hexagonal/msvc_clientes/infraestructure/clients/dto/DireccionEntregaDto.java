package org.unc.hexagonal.msvc_clientes.infraestructure.clients.dto;


import org.unc.hexagonal.msvc_clientes.domain.views.DireccionEntrega;

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