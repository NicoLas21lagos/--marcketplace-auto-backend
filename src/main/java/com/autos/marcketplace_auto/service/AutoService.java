package com.autos.marcketplace_auto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autos.marcketplace_auto.models.Auto;
import com.autos.marcketplace_auto.repository.AutoRepository;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public Auto createAuto(Auto auto) throws Exception {
        try {
            return autoRepository.save(auto);
        } catch (Exception e) {
            throw new Exception("Error al crear: " + e.getMessage());
        }
    }

    public List<Auto> getAllAdministrador() throws Exception {
        try {
            return autoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Auto getAutoById(Integer id) throws Exception {
        try {
            return autoRepository.findById(id)
                    .orElseThrow(() -> new Exception("Este auto no existe!"));
        } catch (Exception e) {
            throw new Exception("Error fetching: " + e.getMessage());
        }
    }

    public Auto updateAuto(Auto auto) throws Exception {
        Auto autoUpdate = autoRepository.findById(auto.getId())
                .orElseThrow(() -> new Exception("Este auto no existe!"));

        autoUpdate.setMarca(auto.getMarca());
        autoUpdate.setModelo(auto.getModelo());
        autoUpdate.setPrecio(auto.getPrecio());
        autoUpdate.setAño(auto.getAño());

        return autoRepository.save(autoUpdate);
    }

    public void deleteAutoById(Integer id) throws Exception {
        if (autoRepository.existsById(id)) {
            throw new Exception("Este auto no existe!");
        }
        autoRepository.deleteById(id);
    }

}
