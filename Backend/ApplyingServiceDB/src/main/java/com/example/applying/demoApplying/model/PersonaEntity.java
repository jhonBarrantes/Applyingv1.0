package com.example.applying.demoApplying.model;

import java.util.List;


public class PersonaEntity {
	Integer id;
	String nombre;
	String apellidos;
	String tipoDocumento;
	String nroDocumento;
	List<Solicitud> listaSolicitudes;
	
	public PersonaEntity(Integer id, String nombre, String apellidos, String tipoDocumento, String nroDocumento, List<Solicitud> listaSolicitudes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.listaSolicitudes= listaSolicitudes;
	}

	public PersonaEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}
	
	
}
