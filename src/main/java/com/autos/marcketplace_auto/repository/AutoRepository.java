package com.autos.marcketplace_auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.marcketplace_auto.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Integer>{
    
}