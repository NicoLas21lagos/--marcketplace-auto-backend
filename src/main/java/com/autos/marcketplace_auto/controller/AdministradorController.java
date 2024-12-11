package com.autos.marcketplace_auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autos.marcketplace_auto.models.Administrador;
import com.autos.marcketplace_auto.service.AdministradorService;

@Controller
@RequestMapping("api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<?> getAllAdministrador() throws Exception {
        try {
            return ResponseEntity.ok(administradorService.getAllAdministrador());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateAdministrador(@RequestBody Administrador administradorUpdate) throws Exception {
        try {
            return ResponseEntity.ok(administradorService.updateAdministrador(administradorUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
