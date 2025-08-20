package org.unc.hexagonal.msvc_clientes.infraestructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.unc.hexagonal.msvc_clientes.domain.models.TipoDocumento;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TipDocumento")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "tipoDocumento",fetch = FetchType.LAZY)
    private List<ClienteEntity> cliente;

    private String nombre;
    private String abreviatura;
    private String longitud;


    public static TipoDocumentoEntity fromDomainModel(TipoDocumento tipoDocumento) {
        if (tipoDocumento == null) {
            return null;
        }
        return TipoDocumentoEntity.builder()
                .id(tipoDocumento.getId())
                .nombre(tipoDocumento.getNombre())
                .abreviatura(tipoDocumento.getAbreviatura())
                .longitud(tipoDocumento.getLongitud())
                .build();
    }

    // Conversión de entidad -> dominio
    public TipoDocumento toDomainModel() {
        return new TipoDocumento(
                id,
                nombre,
                abreviatura,
                longitud
        );
    }


}
