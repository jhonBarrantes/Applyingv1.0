package com.applying.demo.spring.bean;

import java.util.List;

public class MensajeResultado {
	Integer codigo;
	String mensaje;
	String error;
	List<String> detalleMensaje;
	String tipo;
	Object dato;
	
	public MensajeResultado(Integer codigo, String mensaje, String error, List<String> detalleMensaje, String tipo,
			Object dato) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.error = error;
		this.detalleMensaje = detalleMensaje;
		this.tipo = tipo;
		this.dato = dato;
	}
	
	public MensajeResultado(SucessMessageEnum messageConstants, String mensaje ) {
		this.codigo=messageConstants.idMessage();
		this.mensaje=mensaje;
		this.tipo=messageConstants.getTypeMessage();
	}
	public MensajeResultado(ErrorMessageEnum messageConstants, String mensaje ) {
		this.codigo=messageConstants.idMessage();
		this.mensaje=mensaje;
		this.tipo=messageConstants.getTypeMessage();
	}
	
	public MensajeResultado(ErrorMessageEnum messageConstants,List<String> detalleMensaje, String mensaje ) {
		this.codigo=messageConstants.idMessage();
		this.mensaje=mensaje;
		this.tipo=messageConstants.getTypeMessage();
		this.detalleMensaje = detalleMensaje;
	}
	
	public MensajeResultado() {
		super();
	}
	public MensajeResultado(Object dato) {
		super();
		this.dato = dato;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetalleMensaje() {
		return detalleMensaje;
	}
	public void setDetalleMensaje(List<String> detalleMensaje) {
		this.detalleMensaje = detalleMensaje;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
}
