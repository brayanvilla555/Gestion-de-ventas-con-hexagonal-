package org.unc.hexagonal.msvc_ventas.domain.ports.in;

import org.unc.hexagonal.msvc_ventas.domain.models.AditionalVentaInfo;

public interface GetAditionalVentaUseCase {
    AditionalVentaInfo getAditionalVentaInfo(Long id);
}
