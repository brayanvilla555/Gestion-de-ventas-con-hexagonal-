package org.unc.hexagonal.msvc_clientes.infraestructure.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unc.hexagonal.msvc_clientes.application.services.ClienteService;
import org.unc.hexagonal.msvc_clientes.domain.models.Cliente;
import org.unc.hexagonal.msvc_clientes.domain.views.Venta;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    // @Autowired
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        Cliente clienteDB = clienteService.crear(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDB);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarById(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> tasks = clienteService.listar();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente)
                .map(cliente1 -> new ResponseEntity<>(cliente1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if(clienteService.eliminar(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //metodos remotos
    @GetMapping("/{id}/ventas")
    public ResponseEntity<List<Venta>> listarVentas(@PathVariable Long id) {
        List<Venta> ventas = clienteService.getListaVentas(id);
        return ResponseEntity.ok(ventas);
    }




}