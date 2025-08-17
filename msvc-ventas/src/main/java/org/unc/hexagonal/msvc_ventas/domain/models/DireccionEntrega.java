package org.unc.hexagonal.msvc_ventas.domain.models;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class DireccionEntrega {
    private String referencia;
    private String calle;
    private String ciudad;
    private String departamento;
    private String codigoPostal;
}