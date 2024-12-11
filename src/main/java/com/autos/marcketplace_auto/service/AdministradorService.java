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

    public List<Administrador> geAdministrador() throws Exception {
        try {
            return administradorRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching data: " + e.getMessage());

        }
    }
}
