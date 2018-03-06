package com.example.applying.demoApplying.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.applying.demoApplying.model.Persona;
import com.example.applying.demoApplying.repository.PersonaRepository;
import com.example.applying.demoApplying.repository.SolicitudRepository;
import com.example.applying.demoApplying.service.PersonaService;

@Service("personaSolicitud")
public class PersonaServiceImp implements PersonaService{

	private static Log LOGGER= LogFactory.getLog(PersonaService.class);
	
	@Autowired
	@Qualifier("personaRepository")
	private PersonaRepository repositorioPersona;
	
	@Override
	public Integer agregarPersona(Persona persona) {
		LOGGER.info("AGREGAR PERSONA" + persona.getNombre());
		repositorioPersona.save(persona);
		return persona.getId();
	}

	@Override
	public Integer editarPersona(Persona persona) {
		LOGGER.info("EDITAR PERSONA" + persona.getNombre());
		Persona per=buscarPersona(persona.getId());
		if(per!=null)
		repositorioPersona.save(persona);
		return per.getId();
	}

	@Override
	public List<Persona> listarPersonas() {
		List<Persona> personas= repositorioPersona.findAll();
		return personas;
	}

	@Override
	public void eliminarPersona(Integer id) {
		Persona persona=buscarPersona(id);
		if(persona!=null) {
			repositorioPersona.deleteById(id);
		}
	}

	@Override
	public Persona buscarPersona(Integer id) {
		Persona persona=repositorioPersona.findById(id);
		return persona;
	}
	
}
