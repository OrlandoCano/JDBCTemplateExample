package com;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MateriaDaoImpl implements MateriasDao {	
	
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Materia> find() {
		return jdbcTemplate.query("select * from subjects",new MateriaRowMapper());
		
	}

	@Override
	public Materia load(Long id) {
		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("id", id);
		return jdbcTemplate.queryForObject("select * from subjects where id = :id", namedParams, new MateriaRowMapper());
	}

	@Override
	public Materia persist(Materia materia) {
		KeyHolder keyHolder = new GeneratedKeyHolder();	
		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("subjectName", materia.getSubjectName());
		namedParams.addValue("semester", materia.getSemester());
		jdbcTemplate.update("insert into subjects (subject_name, semester) values (:subjectName, :semester) ", namedParams, keyHolder, new String[]{"id"});
		materia.setId(keyHolder.getKey().longValue());
		return materia;
	}

	@Override
	public Materia merge(Materia materia) {
		KeyHolder keyHolder = new GeneratedKeyHolder();	
		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("id", materia.getId());
		namedParams.addValue("subjectName", materia.getSubjectName());
		namedParams.addValue("semester", materia.getSemester());
		jdbcTemplate.update("update subjects set subject_name=:subjectName, semester=:semester where id=:id", namedParams, keyHolder, new String[]{"id"});
		return materia;
	}

	@Override
	public void delete(Long id) {
		MapSqlParameterSource namedParams = new MapSqlParameterSource();
		namedParams.addValue("id", id);
		 jdbcTemplate.update("delete from subjects where id = :id", namedParams);
	}

}
