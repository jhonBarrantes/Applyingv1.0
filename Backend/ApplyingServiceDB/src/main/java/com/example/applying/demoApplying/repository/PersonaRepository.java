package com.example.applying.demoApplying.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.applying.demoApplying.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Serializable>{
	public abstract Persona findById(Integer id);
}
