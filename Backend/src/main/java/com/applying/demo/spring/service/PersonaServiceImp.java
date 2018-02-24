package com.applying.demo.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.Libro;
import com.applying.demo.spring.bean.Persona;
import com.applying.demo.spring.bean.Solicitud;
import com.applying.demo.spring.bean.SolicitudBean;

@Service
public class PersonaServiceImp implements PersonaService{

	static List<Persona> personas = null;
	static List<Solicitud> solicitudes1=null;
	static List<Solicitud> solicitudes2=null;
	
	static {
		solicitudes1 = new ArrayList<Solicitud>();
		solicitudes1.add(new Solicitud(1l,10l,"Comisaria San Juan",1l,"REGISTRADO"));
		solicitudes1.add(new Solicitud(2l,11l,"Comisaria Miraflores",1l,"REGISTRADO"));
		
		solicitudes2 = new ArrayList<Solicitud>();
		solicitudes2.add(new Solicitud(3l,12l,"Comisaria Cercado",1l,"REGISTRADO"));
		solicitudes2.add(new Solicitud(4l,13l,"Comisaria Breña",1l,"REGISTRADO"));
		
		personas = new ArrayList<Persona>();
		personas.add(new Persona(1L,"Jhon","Barrantes","DNI","47464174",solicitudes1));
		personas.add(new Persona(2L,"Cesar","Cuba","DNI","06558850",solicitudes2));
		
	}
	
	@Override
	public Long AgregarPersona(Persona persona) {
		Persona personasMax = Collections.max(personas, Comparator.comparing(c -> c.getId()));
		persona.setId(personasMax.getId()+1);
		personas.add(persona);
		return persona.getId();
	}

	@Override
	public Persona ObtenerPersona(Long id) {
		Persona resSolicitudBean = personas.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		return resSolicitudBean;
	}

	@Override
	public void ActualizarPersona(Persona objPersona) {
		Persona resSolicitudBean = personas.stream()                        // Convert to steam
                .filter(sol -> objPersona.getId().equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		resSolicitudBean.setNombre(objPersona.getNombre());
		resSolicitudBean.setApellidos(objPersona.getApellidos());
		resSolicitudBean.setId(objPersona.getId());
		resSolicitudBean.setTipoDocumento(objPersona.getTipoDocumento());
		resSolicitudBean.setNroDocument(objPersona.getNroDocument());
		resSolicitudBean.setListaSolicitudes(objPersona.getListaSolicitudes());		
	}

	@Override
	public void EliminarLibro(Long id) {
		Persona resSolicitudBean = personas.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resSolicitudBean!=null) {
			personas.remove(resSolicitudBean);
		}
		
	}

	@Override
	public List<Persona> ListarPersonas() {
		return personas;
	}

}
