package com.applying.demo.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.applying.demo.spring.bean.Libro;

@Service("libroServicio")
public class LibroServiceImp implements LibroService{
	private static final Log LOGGER = LogFactory.getLog(LibroService.class);
	static List<Libro> libros = null;

	static {
		libros = new ArrayList<Libro>();
		libros.add(new Libro(1L,"Vientos de Invierno","George R.R. Martin","Inglaterra",200));
		libros.add(new Libro(2L,"La metamorfosis","Franz Kafka","Alemania",150));
		libros.add(new Libro(3L,"El autor","Anonimo","Inglaterra",220));
		libros.add(new Libro(4L,"Cien siglos de Soledad","Gabriel Garcia Marquez","Colombia",200));
		libros.add(new Libro(5L,"La divina comedia","Dante Alighieri","Italia",200));
	}
	
	@Override
	public Long AgregarLibro(Libro libro) {
		Libro libromax= Collections.max(libros, Comparator.comparing(c->c.getId()));
		libro.setId(libromax.getId()+1);
		libros.add(libro);
		return libro.getId();
	}

	@Override
	public Libro ObtenerLibro(Long id) {
		Libro resSolicitudBean = libros.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		return resSolicitudBean;
	}

	@Override
	public void ActualizarLibro(Libro libro) {
		Libro resSolicitudBean = libros.stream()                        // Convert to steam
                .filter(sol -> libro.getId().equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		
		resSolicitudBean.setNombre(libro.getNombre());
		resSolicitudBean.setAutor(libro.getAutor());
		resSolicitudBean.setPais(libro.getPais());
		resSolicitudBean.setStock(libro.getStock());
		
	}

	@Override
	public void EliminarLibro(Long id) {
		Libro resSolicitudBean = libros.stream()                        // Convert to steam
                .filter(sol -> id.equals(sol.getId()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);  
		if(resSolicitudBean!=null) {
			libros.remove(resSolicitudBean);
		}
	}

	@Override
	public List<Libro> ListarLibros() {
		return libros;
	}
}
