package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MateriaRowMapper implements RowMapper<Materia>{

	@Override
	public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new MateriaExtractor().extractData(rs);
	}
	
}
