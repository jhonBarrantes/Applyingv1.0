package com.applying.demo.spring.service;

import java.util.List;
import com.applying.demo.spring.bean.Persona;

public interface PersonaService {
	public Long AgregarPersona(Persona persona);

	public Persona ObtenerPersona(Long id);

	public void ActualizarPersona(Persona persona);

	public void EliminarLibro(Long id);

	public List<Persona> ListarPersonas();
}
