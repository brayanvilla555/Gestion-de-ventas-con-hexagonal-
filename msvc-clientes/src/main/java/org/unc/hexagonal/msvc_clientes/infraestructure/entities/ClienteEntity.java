package org.unc.hexagonal.msvc_clientes.infraestructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.models.TipoDocumento;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private TipoDocumentoEntity tipoDocumento;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El nombre es obligatorio")
    private String apellido;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo debe ser valido")
    private String correo;

    private String telefono;

    private String numeroIdentificacion;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean estado; //activo(true) o inactivo(false)

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (estado == null) {
            estado = true;
        }
    }


    // convertimos del dominio a la entidad
    public static ClienteEntity fromDomainModel(Cliente cliente){
        return new     ClienteEntity(cliente.getId(), TipoDocumentoEntity.fromDomainModel(cliente.getTipoDocumento()),cliente.getNombre(), cliente.getApellido(), cliente.getCorreo(), cliente.getTelefono(), cliente.getNumeroIdentificacion(), cliente.getEstado(), cliente.getCreatedAt(), cliente.getUpdatedAt());
    }

    // de la entidad al dominio
    public Cliente toDomainModel(){
        return new Cliente(id, tipoDocumento.toDomainModel(), nombre, apellido, correo, telefono, numeroIdentificacion,estado,createdAt, updatedAt);
    }

}
