package com.example.applying.demoApplying.model;

public enum MessageType {
	WARNING("warning"),
 	SUCCESS("success");
	private String tipo;
	MessageType(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}		
}
