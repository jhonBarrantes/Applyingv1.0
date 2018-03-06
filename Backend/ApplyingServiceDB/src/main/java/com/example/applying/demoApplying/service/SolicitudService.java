package com.example.applying.demoApplying.service;

import java.util.List;

import com.example.applying.demoApplying.model.Solicitud;

public interface SolicitudService {
	public int agregarSolicitud(Solicitud solicitud);
	public int modificarSolicitud(Solicitud solicitud);
	public List<Solicitud> listarSolicitudes();
	public void eliminarSolicitud(int id);
	public Solicitud buscarSolicitud(int id);
	public List<Solicitud> listaPorPersona(int idPersona);
}

