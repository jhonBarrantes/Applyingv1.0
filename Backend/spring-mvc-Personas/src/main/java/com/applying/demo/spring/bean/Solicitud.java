package com.applying.demo.spring.bean;

public class Solicitud {
	private Long id; 
	private Long institucionId; 
	private String institucionNombre;
	private Long estadoId;
	private String estadoNombre;

	public Solicitud() {
		super();
	}

	public Solicitud(Long id, Long institucionId, String institucionNombre, Long estadoId, String estadoNombre) {
		super();
		this.id = id;
		this.institucionId = institucionId;
		this.institucionNombre = institucionNombre;
		this.estadoId = estadoId;
		this.estadoNombre = estadoNombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getInstitucionId() {
		return institucionId;
	}

	public void setInstitucionId(Long institucionId) {
		this.institucionId = institucionId;
	}

	public String getInstitucionNombre() {
		return institucionNombre;
	}

	public void setInstitucionNombre(String institucionNombre) {
		this.institucionNombre = institucionNombre;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	public String getEstadoNombre() {
		return estadoNombre;
	}

	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}

	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", institucionId=" + institucionId + ", institucionNombre=" + institucionNombre
				+ ", estadoId=" + estadoId + ", estadoNombre=" + estadoNombre + "]";
	}

	
	
	
}
