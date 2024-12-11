package com.autos.marcketplace_auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autos.marcketplace_auto.models.Cliente;
import com.autos.marcketplace_auto.service.ClienteService;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente clienteCreate) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.saveCliente(clienteCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCliente() throws Exception {
        try {
            return ResponseEntity.ok(clienteService.getAllClientes());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{clienteID}")
    public ResponseEntity<?> getClienteById(@PathVariable Integer clienteID) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.getClienteById(clienteID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCliente(@RequestBody Cliente clienteUpdate) throws Exception {
        try {
            return ResponseEntity.ok(clienteService.updateCliente(clienteUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{clienteID}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer clienteID) throws Exception {
        try {
            clienteService.deleteClienteById(clienteID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
