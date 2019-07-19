package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class MateriaExtractor implements ResultSetExtractor<Materia> {
	
	@Override
	public Materia extractData(ResultSet rs) throws SQLException, DataAccessException {
		Materia m = new Materia();
		m.setId(rs.getLong("id"));
		m.setSubjectName(rs.getString("subject_name"));
		m.setSemester(rs.getInt("semester"));
		
		return m;
		
	}

}
