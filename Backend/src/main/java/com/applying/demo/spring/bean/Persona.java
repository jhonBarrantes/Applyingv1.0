package com.applying.demo.spring.bean;

import java.util.List;

public class Persona {
	private Long id;
	private String nombre;
	private String apellidos;
	private String tipoDocumento;
	private String nroDocumento;
	private List<Solicitud> listaSolicitudes;
	
	public Persona(Long id,String nombre, String apellidos, String tipoDocumento, String nroDocument,
			List<Solicitud> listaSolicitudes) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocument;
		this.listaSolicitudes = listaSolicitudes;
	}
	public Persona() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getNroDocument() {
		return nroDocumento;
	}
	public void setNroDocument(String nroDocument) {
		this.nroDocumento = nroDocument;
	}
	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}
	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", tipoDocumento=" + tipoDocumento
				+ ", nroDocument=" + nroDocumento + ", listaSolicitudes=" + listaSolicitudes + "]";
	}
	
	
}
