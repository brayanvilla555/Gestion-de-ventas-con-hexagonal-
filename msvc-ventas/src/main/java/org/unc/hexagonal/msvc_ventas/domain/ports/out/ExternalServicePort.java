package org.unc.hexagonal.msvc_ventas.domain.ports.out;

import org.unc.hexagonal.msvc_ventas.domain.models.AditionalVentaInfo;

public interface ExternalServicePort {
    AditionalVentaInfo getAditionalVentaInfo(Long id);
}
