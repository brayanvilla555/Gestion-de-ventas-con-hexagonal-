package org.unc.hexagonal.msvc_clientes.domain.models;



import java.time.LocalDateTime;

public class Cliente {
    private Long id;
    private TipoDocumento tipoDocumento;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String numeroIdentificacion;
    private Boolean estado; //activo(true) o inactivo(false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Cliente(Long id, TipoDocumento tipoDocumento, String nombre, String apellido, String correo, String telefono, String numeroIdentificacion, Boolean estado, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.numeroIdentificacion = numeroIdentificacion;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public Cliente setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Cliente setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public Cliente setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public String getTelefono() {
        return telefono;
    }

    public Cliente setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public Cliente setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public Boolean getEstado() {
        return estado;
    }

    public Cliente setEstado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Cliente setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Cliente setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
