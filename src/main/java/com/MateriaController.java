package com;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriaController {
	@Autowired
	private MateriaService service;
	
	@RequestMapping(value="materia", method=RequestMethod.GET)
	public Collection<Materia> loadMaterias(){
		return service.load();
	}
	
	@RequestMapping(value="materia/{id}", method=RequestMethod.GET)
	public Materia loadMateria(@PathVariable Long id) {
		return service.load(id);
	}
	
	@RequestMapping(value="materia", method=RequestMethod.POST)
	public ResponseEntity<Materia> create(@RequestBody Materia materia) {
		service.create(materia);
		return new ResponseEntity<Materia>(materia, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="materia", method=RequestMethod.PUT)
	public Materia update(@RequestBody Materia materia) {
		return service.save(materia);
	}
	
	@RequestMapping(value="materia/{id}", method=RequestMethod.DELETE )
	public void deleteMateria(@PathVariable Long id, HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		service.delete(id);
	}
	
}
