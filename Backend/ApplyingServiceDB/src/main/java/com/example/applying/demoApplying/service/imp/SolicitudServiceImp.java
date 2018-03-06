package com.example.applying.demoApplying.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.applying.demoApplying.model.Solicitud;
import com.example.applying.demoApplying.repository.SolicitudRepository;
import com.example.applying.demoApplying.service.SolicitudService;

@Service("servicioSolicitud")
public class SolicitudServiceImp implements SolicitudService{

	private static Log LOGGER= LogFactory.getLog(SolicitudService.class);
	
	@Autowired
	@Qualifier("solicitudRepository")
	private SolicitudRepository repositorioSolicitud;
	

	@Override
	public int agregarSolicitud(Solicitud solicitud) {
		LOGGER.info("AGREGAR SOLICITUD" + solicitud.getSolicitante()+solicitud.getId());
		repositorioSolicitud.save(solicitud);
		return solicitud.getId();
	}

	@Override
	public int modificarSolicitud(Solicitud solicitud) {
		LOGGER.info("MODIFICAR SOLICITUD" + solicitud.getSolicitante()+solicitud.getId());
		Solicitud sol=buscarSolicitud(solicitud.getId());
		if(sol!=null)
		repositorioSolicitud.save(solicitud);
		return sol.getId();
	}

	
	@Override
	public List<Solicitud> listarSolicitudes() {
		List<Solicitud> solicitudes= repositorioSolicitud.findAll();
		return solicitudes;
	}

	@Override
	public List<Solicitud> listaPorPersona(int idPersona) {
		List<Solicitud> solicitudes= repositorioSolicitud.findListByPersona(idPersona);
		return solicitudes;
	}
	
	
	@Override
	public void eliminarSolicitud(int id) {
		Solicitud solicitud=buscarSolicitud(id);
		if(solicitud!=null) {
			repositorioSolicitud.deleteById(id);
//			repositorioSolicitud.delete(solicitud.getId());
		}
		
	}

	@Override
	public Solicitud buscarSolicitud(int id) {
		Solicitud solicitud = repositorioSolicitud.findById(id);
		LOGGER.info("ENCONTRANDO LA SOLICITUD:"+solicitud.getId() + " - "+ solicitud.getInstitucion());
		return solicitud;
	}


	
}
