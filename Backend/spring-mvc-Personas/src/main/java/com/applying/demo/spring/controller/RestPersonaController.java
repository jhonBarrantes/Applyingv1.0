package com.applying.demo.spring.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.applying.demo.spring.bean.MensajeResultado;
import com.applying.demo.spring.bean.Persona;
import com.applying.demo.spring.bean.ResultMessage;
import com.applying.demo.spring.bean.SolicitudBean;
import com.applying.demo.spring.bean.SuccessMessageEnum;
import com.applying.demo.spring.bean.SucessMessageEnum;
import com.applying.demo.spring.service.PersonaService;

import java.util.Locale;

@RestController
public class RestPersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	MessageSource msg;
	
	@RequestMapping(value="/personas", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> listarPersonas(){
		System.out.println("Listar Personas");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(personaService.ListarPersonas());
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/persona/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerPersona(@PathVariable("id") Long id){
		System.out.println("Obtener Persona: "+ id);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO);
		result.setData(personaService.ObtenerPersona(id));
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_BUSQUEDA_EXITO.getHttpStatus());
	}
	

	
	@RequestMapping(value="/persona", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> agregarPersona(@RequestBody Persona persona,Errors erros, Locale objLocale) throws Exception{
		System.out.println("Agregar Persona:" + persona.toString());
		long personaId = personaService.AgregarPersona(persona);
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO);
		response.setData(personaId);
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.getHttpStatus());
	}

	
	@RequestMapping(value="/persona/{id}", method= RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> actualizarPersona(@PathVariable("id")Long id,@RequestBody Persona persona,Locale objLocale){
		System.out.println("Modificar Persona:" + id);
		persona.setId(id);
		System.out.println("Persona: "+ persona.toString());
		personaService.ActualizarPersona(persona);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO);
		result.setData(persona.getId());
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.getHttpStatus());
	}
	
	@RequestMapping(value="/persona/{id}", method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> eliminarPersona(@PathVariable("id")Long id){
		System.out.println("Eliminar Persona: "+ id);
		ResultMessage result = new ResultMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO);
		personaService.EliminarLibro(id);
		result.setData(id);
		return new ResponseEntity<ResultMessage>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO.getHttpStatus());
	}
	
	
	

}
