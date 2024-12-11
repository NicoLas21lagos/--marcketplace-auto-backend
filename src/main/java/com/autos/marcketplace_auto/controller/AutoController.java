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

import com.autos.marcketplace_auto.models.Auto;
import com.autos.marcketplace_auto.service.AutoService;

@Controller
@RequestMapping("api/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @PostMapping
    public ResponseEntity<?> createAuto(@RequestBody Auto autoCreate) throws Exception {
        try {
            return ResponseEntity.ok(autoService.createAuto(autoCreate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllAutos() throws Exception {
        try {
            return ResponseEntity.ok(autoService.getAllAutos());
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{autoID}")
    public ResponseEntity<?> getAutoById(@PathVariable Integer autoID) throws Exception {
        try {
            return ResponseEntity.ok(autoService.getAutoById(autoID));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateAuto(@RequestBody Auto autoUpdate) throws Exception {
        try {
            return ResponseEntity.ok(autoService.updateAuto(autoUpdate));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/autoID")
    public ResponseEntity<?> deleteAuto(@PathVariable Integer autoID) throws Exception {
        try {
            autoService.deleteAutoById(autoID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
