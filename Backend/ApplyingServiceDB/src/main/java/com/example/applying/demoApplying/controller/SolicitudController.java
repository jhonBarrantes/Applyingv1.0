package com.example.applying.demoApplying.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.applying.demoApplying.model.ResultMessage;
import com.example.applying.demoApplying.model.Solicitud;
import com.example.applying.demoApplying.model.SuccessMessageEnum;
import com.example.applying.demoApplying.service.SolicitudService;

@RestController
public class SolicitudController {

	@Autowired
	SolicitudService servicioSolicitud;
	
//	@RequestMapping(value="/solicitudes2", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<ResultMessage> obtenerSolicitudes2(){
//		System.out.println("Solicitudes");
//		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
//		response.setData(servicioSolicitud.listaPorPersona(1));
//		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
//	}
	
	
	@RequestMapping(value="/solicitudes", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> obtenerSolicitudes(){
		System.out.println("Solicitudes");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(servicioSolicitud.listarSolicitudes());
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/agregarSolicitud", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> agregarSolicitud(){
		System.out.println("agregar solicitud");
		Solicitud solicitud= new Solicitud();
		solicitud.setPersona(1);
		solicitud.setInstitucion("demo");
		solicitud.setSolicitante("demoJhon");
		solicitud.setEstado("REGISTRADO");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(servicioSolicitud.agregarSolicitud(solicitud));
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/modificar", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> editarSolicitud(){
		System.out.println("editar solicitud");
		Solicitud solicitud= new Solicitud();
		solicitud.setId(8);
		solicitud.setPersona(1);
		solicitud.setInstitucion("abc");
		solicitud.setSolicitante("abcdeipdasdne");
		solicitud.setEstado("REGISTRADO");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		response.setData(servicioSolicitud.modificarSolicitud(solicitud));
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
	
	@RequestMapping(value="/eliminar", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResultMessage> eliminar(){
		System.out.println("editar solicitud");
		ResultMessage response = new ResultMessage(SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS);
		servicioSolicitud.eliminarSolicitud(8);
		response.setData("");
		return new ResponseEntity<ResultMessage>(response,SuccessMessageEnum.MESSAGE_GENERAL_SUCCESS.getHttpStatus());
	}
}
