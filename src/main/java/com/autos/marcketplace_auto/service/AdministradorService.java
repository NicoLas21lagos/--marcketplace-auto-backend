package com.autos.marcketplace_auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autos.marcketplace_auto.models.Administrador;
import com.autos.marcketplace_auto.repository.AdministradorRepository;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAllAdministrador() throws Exception {
        try {
            return administradorRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());

        }
    }

    public Administrador updateAdministrador(Administrador administrador) throws Exception {
        Administrador administradorUpdate = administradorRepository.findById(administrador.getId())
                .orElseThrow(() -> new Exception("Este administrador no existe!"));

        administradorUpdate.setNombre(administrador.getNombre());
        administradorUpdate.setEmail(administrador.getEmail());
        administradorUpdate.setUsername(administrador.getUsername());
        administradorUpdate.setPassword(administrador.getPassword());

        return administradorRepository.save(administradorUpdate);
    }
}
