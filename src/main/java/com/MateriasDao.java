package com;

import java.util.Collection;

public interface MateriasDao {
	Collection<Materia>find();
	Materia load(Long id);
	Materia persist(Materia materia);
	Materia merge(Materia materia);
	void delete(Long id);
}
