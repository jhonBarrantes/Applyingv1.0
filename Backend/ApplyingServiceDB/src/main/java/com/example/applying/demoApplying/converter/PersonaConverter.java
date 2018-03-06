package com.example.applying.demoApplying.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.applying.demoApplying.model.Persona;
import com.example.applying.demoApplying.model.Solicitud;
import com.example.applying.demoApplying.model.PersonaEntity;

@Component("personaConverter")
public class PersonaConverter {
	public PersonaEntity PersonaToPersonaEntity(Persona persona,List<Solicitud> listaSolicitudes) {
		PersonaEntity per= new PersonaEntity();
		per.setNombre(persona.getNombre());
		per.setApellidos(persona.getApellidos());
		per.setId(persona.getId());
		per.setNroDocumento(persona.getNroDocumento());
		per.setTipoDocumento(persona.getTipoDocumento());
		per.setListaSolicitudes(listaSolicitudes);
		return per;
	}
	
	public Persona PersonaEntityToPersona(PersonaEntity persona) {
		Persona per=new Persona();
		per.setNombre(persona.getNombre());
		per.setApellidos(persona.getApellidos());
		per.setId(persona.getId());
		per.setNroDocumento(persona.getNroDocumento());
		per.setTipoDocumento(persona.getTipoDocumento());
		return per;
	}
	
	public List<Solicitud> PersonaEntityToSolicitudes(PersonaEntity persona) {
		List<Solicitud> listaSolicitudes= new ArrayList<Solicitud>();
		listaSolicitudes=persona.getListaSolicitudes();
		return listaSolicitudes;
	}
}
