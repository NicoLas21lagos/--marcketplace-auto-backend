package com.autos.marcketplace_auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autos.marcketplace_auto.models.Cliente;
import com.autos.marcketplace_auto.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) throws Exception {
        try {
            return clienteRepository.save(cliente);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }

    }

    public List<Cliente> getAllClientes() throws Exception {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Cliente getClienteById(Integer id) throws Exception {
        try {
            return clienteRepository.findById(id).orElseThrow(() -> new Exception("El cliente no existe!"));

        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Cliente updateCliente(Cliente cliente) throws Exception {
        Cliente clienteUpdate = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new Exception("El cliente no existe!"));

        clienteUpdate.setNombre(cliente.getNombre());
        clienteUpdate.setApellido(cliente.getApellido());
        clienteUpdate.setEmail(cliente.getEmail());
        clienteUpdate.setUsername(cliente.getUsername());
        clienteUpdate.setPassword(cliente.getPassword());

        return clienteRepository.save(clienteUpdate);
    }

    public void deleteClienteById(Integer id) throws Exception {
        if (clienteRepository.existsById(id)) {
            throw new Exception("Este cliente no existe!");
        }
        clienteRepository.deleteById(id);
    }

}
