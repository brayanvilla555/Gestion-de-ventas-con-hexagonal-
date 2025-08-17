package org.unc.hexagonal.msvc_ventas.infrastructure.adapters;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.unc.hexagonal.msvc_ventas.domain.models.AditionalVentaInfo;
import org.unc.hexagonal.msvc_ventas.domain.ports.out.ExternalServicePort;

import java.time.LocalDateTime;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AditionalVentaInfo getAditionalVentaInfo(Long id) {
        //petición hacia el producto
        String apiUrlProducto = "http://localhost:8070/api/producto/";
        ResponseEntity<Producto> responseProducto = restTemplate.getForEntity(apiUrlProducto+id, Producto.class);
        Producto producto = responseProducto.getBody();

        //peticion hacia el cliente
        String apiUrl = "http://localhost:8090/clientes/buscar/";
        ResponseEntity<Cliente> ventaResponse = restTemplate.getForEntity(apiUrl+id, Cliente.class, id);
        Cliente cliente = ventaResponse.getBody();

        if(cliente == null) {
            return null;
        }

        if(!ventaResponse.getStatusCode().is2xxSuccessful()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Tenemos problemas consultando al servicio externo");
        }

        return new AditionalVentaInfo(
                cliente.id,
                cliente.nombre,
                producto.nombre,
                cliente.correo,
                cliente.telefono,
                cliente.numeroIdentificacion,
                cliente.estado
        );
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Producto{
        private Long id;
        private String nombre;
        private String categoria;
        private Double precio;
        private String imagen;
        private Integer stockTienda;
        private Integer stockAlmacen;
        //private EstadoProducto estado;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaActualizacion;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Cliente{
        private Long id;

        //private TipoDocumentoDto tipoDocumento;

        private String nombre;

        private String apellido;

        private String correo;

        private String telefono;

        private String numeroIdentificacion;

        private Boolean estado;
    }
}
