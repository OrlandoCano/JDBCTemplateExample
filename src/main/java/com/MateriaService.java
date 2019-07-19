package com;

import java.util.Collection;

public interface MateriaService {
	Collection<Materia> load();
	Materia load(Long id);
	Materia create(Materia materia);
	Materia save(Materia materia);
	void delete(Long id);
}
