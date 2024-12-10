package com.autos.marcketplace_auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.marcketplace_auto.models.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
    
}
