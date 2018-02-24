package com.applying.demo.spring.bean;

public class Libro {
	private Long id;
	private String nombre;
	private String autor;
	private String pais;
	private int stock;

	public Libro() {
		super();
	}
	
	@Override
	public String toString() {
		return "LibroBean [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", pais=" + pais + ", stock=" + stock
				+ "]";
	}

	public Libro(Long id, String nombre, String autor, String pais, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.pais = pais;
		this.stock = stock;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
