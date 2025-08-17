package org.unc.hexagonal.msvc_ventas.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AditionalVentaInfo {
    private Long id;

    //private TipoDocumentoDto tipoDocumento;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private String numeroIdentificacion;

    private Boolean estado;
}
