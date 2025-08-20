package org.unc.hexagonal.msvc_clientes.domain.models;
import java.util.List;

public class TipoDocumento {
    private Long id;
    private String nombre;
    private String abreviatura;
    private String longitud;

    public TipoDocumento(Long id, String nombre, String abreviatura, String longitud) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.longitud = longitud;
    }

    public Long getId() {
        return id;
    }

    public TipoDocumento setId(Long id) {
        this.id = id;
        return this;
    }


    public String getNombre() {
        return nombre;
    }

    public TipoDocumento setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public TipoDocumento setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
        return this;
    }

    public String getLongitud() {
        return longitud;
    }

    public TipoDocumento setLongitud(String longitud) {
        this.longitud = longitud;
        return this;
    }
}
