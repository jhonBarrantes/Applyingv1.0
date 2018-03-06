package com.example.applying.demoApplying.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.applying.demoApplying.model.Solicitud;


public interface SolicitudRepository extends JpaRepository<Solicitud,Serializable>{
	public abstract Solicitud findById(int id);
	
	public abstract List<Solicitud> findListByPersona(int persona);
}
