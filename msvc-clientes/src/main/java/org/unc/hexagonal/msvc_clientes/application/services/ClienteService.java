package org.unc.hexagonal.msvc_clientes.application.services;

import org.springframework.transaction.annotation.Transactional;
import org.unc.hexagonal.msvc_clientes.application.dto.ClienteVentaResponseDto;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.views.Venta;
import org.unc.hexagonal.msvc_clientes.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class ClienteService implements ActualizarClienteUseCase, CrearClienteUseCase, EliminarClienteUseCase, ListClienteUseCase, GetInformacionAdicionalClienteUseCase {

    private final CrearClienteUseCase crearClienteUseCase;
    private final ListClienteUseCase listClienteUseCase;
    private final ActualizarClienteUseCase actualizarClienteUseCase;
    private final EliminarClienteUseCase eliminarClienteUseCase;
    private final GetInformacionAdicionalClienteUseCase getInformacionAdicionalClienteUseCase;
    private final GetClienteDetalleCompletoUseCase getClienteDetalleCompleto;

    public ClienteService(CrearClienteUseCase crearClienteUseCase, ListClienteUseCase listClienteUseCase, ActualizarClienteUseCase actualizarClienteUseCase, EliminarClienteUseCase eliminarClienteUseCase, GetInformacionAdicionalClienteUseCase getInformacionAdicionalClienteUseCase, GetClienteDetalleCompletoUseCase getClienteDetalleCompleto) {
        this.crearClienteUseCase = crearClienteUseCase;
        this.listClienteUseCase = listClienteUseCase;
        this.actualizarClienteUseCase = actualizarClienteUseCase;
        this.eliminarClienteUseCase = eliminarClienteUseCase;
        this.getInformacionAdicionalClienteUseCase = getInformacionAdicionalClienteUseCase;
        this.getClienteDetalleCompleto = getClienteDetalleCompleto;
    }

    @Override
    public Optional<Cliente> actualizar(Long id, Cliente cliente) {
        return actualizarClienteUseCase.actualizar(id, cliente);
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return crearClienteUseCase.crear(cliente);
    }

    @Override
    public boolean eliminar(Long id) {
        return eliminarClienteUseCase.eliminar(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarById(Long id) {
        return listClienteUseCase.buscarById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return listClienteUseCase.listar();
    }


    @Override
    public List<Venta> getListaVentas(Long idCliente) {
        return getInformacionAdicionalClienteUseCase.getListaVentas(idCliente);
    }



    // aqui me queda la duda si se implementa
    @Transactional(readOnly = true)
    public ClienteVentaResponseDto obtenerClienteDetalleCompleto(Long clienteId) {
        return getClienteDetalleCompleto.ejecutar(clienteId);
    }



}
