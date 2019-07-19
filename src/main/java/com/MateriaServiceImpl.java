package com;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService{
	private static final Logger log= LoggerFactory.getLogger(MateriaServiceImpl.class);
	private Map<Long, Materia> db = new HashMap<Long, Materia>();
	private static long count = 1;
	
	@Autowired
	private MateriasDao dao;
	
	
	@Override
	public Collection<Materia> load() {
		return dao.find();
	}

	@Override
	public Materia load(Long id) {
		return dao.load(id);
	}

	@Override
	public Materia create(Materia materia) {
		return dao.persist(materia);
	}

	@Override
	public Materia save(Materia materia) {
		return dao.merge(materia);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

}
