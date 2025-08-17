package org.unc.hexagonal.msvc_ventas.domain.ports.in;


public interface DeleteVentaUseCase {
    boolean deleteVenta(Long id);
}