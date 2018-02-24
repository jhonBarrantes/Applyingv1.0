package com.applying.demo.spring.controller;

import java.util.Locale;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.applying.demo.spring.bean.Libro;
import com.applying.demo.spring.bean.MensajeResultado;
import com.applying.demo.spring.bean.SuccessMessageEnum;
import com.applying.demo.spring.service.LibroService;

@RestController
public class RestLibroController {
	@Autowired
	@Qualifier("libroServicio")
	LibroService libroService;
	
	
	@Autowired
	MessageSource msg;
	
	
	@RequestMapping(value="/libros", method = RequestMethod.GET)
	public ResponseEntity<MensajeResultado> listarLibros() throws Exception{
		System.out.println("listarLibros");
		MensajeResultado response = new MensajeResultado(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setDato(libroService.ListarLibros());
		return new ResponseEntity<MensajeResultado>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/libro/{id}", method=RequestMethod.GET)
	public ResponseEntity<MensajeResultado> obtenerLibro(@PathVariable("id") Long id) throws Exception{
		System.out.println("Obtener libro: "+ id);
		MensajeResultado response= new MensajeResultado(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		Libro libro = libroService.ObtenerLibro(id);
		response.setDato(libro);
		return new ResponseEntity<MensajeResultado>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
//	{
//		  "nombre":"Vientos de Invierno","autor":"George R.R. Martin","pais":"Inglaterra","stock":200
//		}
	@RequestMapping(value="/libro" , method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MensajeResultado> agregarLibro(@RequestBody Libro libro, Errors error,Locale locale) throws Exception{
		System.out.println("Agregar libro: "+ libro.getNombre());
		Long idLibro = libroService.AgregarLibro(libro);
		String mensaje = msg.getMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.codeMessage(), new Object[] {libro.getId()}, locale);
		MensajeResultado result = new MensajeResultado(SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO);
		result.setDato(idLibro);
		return new ResponseEntity<MensajeResultado>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_REGISTRO_EXITO.getHttpStatus());
		
	}
	
	@RequestMapping(value="/libro/{id}", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MensajeResultado> modificarLibro(@PathVariable("id") Long id,@RequestBody Libro libro, Errors error, Locale locale) throws Exception{
		System.out.println("Modificar libro: "+ id);
		libro.setId(id);
		libroService.ActualizarLibro(libro);
		String mensaje= msg.getMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.codeMessage(), new Object[] {libro.getId()},locale);
		MensajeResultado result = new MensajeResultado(SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO);
		result.setDato(libro.getId());
		return new ResponseEntity<MensajeResultado>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ACTUALIZACION_EXITO.getHttpStatus());	
	}
	
	@RequestMapping(value="/libro/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MensajeResultado> eliminarLIbro(@PathVariable("id")Long id,Locale locale) throws Exception{
		System.out.println("Eliminar libro: "+ id);
		libroService.EliminarLibro(id);
		String mensaje = msg.getMessage(SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO.codeMessage(),new Object[] {id}, locale);
		MensajeResultado result = new MensajeResultado(SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO);
		result.setDato(id);
		return new ResponseEntity<MensajeResultado>(result,SuccessMessageEnum.MENSAJE_SOLICITUD_ELIMINACION_EXITO.getHttpStatus());		
	}
}
