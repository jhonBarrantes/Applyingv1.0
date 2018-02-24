package com.applying.demo.spring.service;

import java.util.List;

import com.applying.demo.spring.bean.Libro;


public interface LibroService {
	public Long AgregarLibro(Libro libro);

	public Libro ObtenerLibro(Long id);

	public void ActualizarLibro(Libro libro);

	public void EliminarLibro(Long id);

	public List<Libro> ListarLibros();
}
