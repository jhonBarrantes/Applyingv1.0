package com.example.applying.demoApplying.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.applying.demoApplying.converter.PersonaConverter;
import com.example.applying.demoApplying.model.Persona;
import com.example.applying.demoApplying.model.PersonaEntity;
import com.example.applying.demoApplying.model.ResultMessage;
import com.example.applying.demoApplying.model.SuccessMessageEnum;
import com.example.applying.demoApplying.service.PersonaService;
import com.example.applying.demoApplying.service.SolicitudService;



@RestController
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private PersonaConverter personaConverter;
	
	@Autowired
	MessageSource msg;
	
	@RequestMapping(value="/personas2", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> listarPersonas2(){
		System.out.println("Listar Personas");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		Persona persona= new Persona();
		persona.setId(10);
		persona.setNombre("demo");
		persona.setApellidos("demo2");
		persona.setTipoDocumento("dni");
		persona.setNroDocumento("13797230");
		personaService.eliminarPersona(10);
		response.setData("OK");
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/personas", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> listarPersonas(){
		System.out.println("Listar Personas");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		List<PersonaEntity> personas= new ArrayList();
		PersonaEntity perEntity;
		List<Persona> listaPersonas= personaService.listarPersonas();
		for(Persona per: listaPersonas) {
			perEntity=personaConverter.PersonaToPersonaEntity(per, solicitudService.listaPorPersona(per.getId())); 
			personas.add(perEntity);
		}
		response.setData(personas);
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/persona/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerPersona(@PathVariable("id") Integer id){
		System.out.println("Obtener Persona: "+ id);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO);
		Persona p=personaService.buscarPersona(id);
		PersonaEntity persona=personaConverter.PersonaToPersonaEntity(p, solicitudService.listaPorPersona(p.getId()));
		result.setData(persona);
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_BUSQUEDA_EXITO.getHttpStatus());
	}
	

	
	@RequestMapping(value="/persona", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> agregarPersona(@RequestBody Persona persona,Errors erros, Locale objLocale) throws Exception{
		System.out.println("Agregar Persona:" + persona.toString());
		long personaId = personaService.agregarPersona(persona);
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO);
		response.setData(personaId);
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.getHttpStatus());
	}

	
	@RequestMapping(value="/persona/{id}", method= RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarPersona(@PathVariable("id")Integer id,@RequestBody Persona persona,Locale objLocale){
		System.out.println("Modificar Persona:" + id);
		persona.setId(id);
		System.out.println("Persona: "+ persona.toString());
		personaService.editarPersona(persona);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO);
		result.setData(persona.getId());
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.getHttpStatus());
	}
	
	@RequestMapping(value="/persona/{id}", method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> eliminarPersona(@PathVariable("id")Integer id){
		System.out.println("Eliminar Persona: "+ id);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO);
		personaService.eliminarPersona(id);
		result.setData(id);
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO.getHttpStatus());
	}
}
