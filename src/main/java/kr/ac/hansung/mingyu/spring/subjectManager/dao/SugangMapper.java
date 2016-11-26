package kr.ac.hansung.mingyu.spring.subjectManager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Sugang;

public class SugangMapper implements RowMapper<Sugang>{
	
	@Override
	public Sugang mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sugang sugang = new Sugang();
		
		sugang.setSugang_id(rs.getInt("sugang_id"));
		sugang.setCourse_code(rs.getString("course_code"));
		sugang.setCourse_name(rs.getString("course_name"));
		sugang.setCourse_type(rs.getString("course_type"));
		sugang.setCourse_point(rs.getInt("course_point"));
		
		return sugang;
	}
	
}
