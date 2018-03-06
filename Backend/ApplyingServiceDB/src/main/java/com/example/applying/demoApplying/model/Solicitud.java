package com.example.applying.demoApplying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "solicitud")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	@Column(name="institucion")
	String institucion;
	
	@Column(name="solicitante")
	String solicitante;
	
	@Column(name="estado")
	String estado;
	
	@NotNull
	@Column(name="persona")
	Integer persona;

	public Solicitud(int id, String institucion, String solicitante,String estado, @NotNull Integer persona) {
		super();
		this.id = id;
		this.institucion = institucion;
		this.solicitante = solicitante;
		this.estado = estado;
		this.persona = persona;
	}

	public Solicitud() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
}
