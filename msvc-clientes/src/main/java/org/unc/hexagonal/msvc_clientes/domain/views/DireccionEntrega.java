package org.unc.hexagonal.msvc_clientes.domain.views;



public class DireccionEntrega {
    private String referencia;
    private String calle;
    private String ciudad;
    private String departamento;
    private String codigoPostal;

    public DireccionEntrega(String referencia, String calle, String ciudad, String departamento, String codigoPostal) {
        this.referencia = referencia;
        this.calle = calle;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.codigoPostal = codigoPostal;
    }
}