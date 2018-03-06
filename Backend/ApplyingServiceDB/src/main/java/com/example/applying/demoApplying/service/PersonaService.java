package com.example.applying.demoApplying.service;

import java.util.List;

import com.example.applying.demoApplying.model.Persona;


public interface PersonaService {
	public Integer agregarPersona(Persona persona);
	public Integer editarPersona(Persona persona);
	public List<Persona> listarPersonas();
	public void eliminarPersona(Integer id);
	public Persona buscarPersona(Integer id);
}
