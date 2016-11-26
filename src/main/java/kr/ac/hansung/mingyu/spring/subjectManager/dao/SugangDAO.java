package kr.ac.hansung.mingyu.spring.subjectManager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Sugang;

@Repository
public class SugangDAO {
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}	
	
	public boolean insert(Sugang sugangData){
		String sqlStatement = "INSERT "
							+ "INTO sugang(course_code, course_name, course_type, course_point) "
							+ "VALUES(?, ?, ?, ?)";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{sugangData.getCourse_code(), sugangData.getCourse_name(), sugangData.getCourse_type(), sugangData.getCourse_point()}) == 1);
	}
	
	public boolean delete(Integer sugang_id){
		String sqlStatement = "DELETE "
							+ "FROM sugang "
							+ "WHERE id = ?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{sugang_id}) == 1);
	}
	
	public List<Sugang> getSugangList(){
		String sqlStatement = "SELECT sugang_id, course_code, course_name, course_type, course_point "
							+ "FROM sugang ";
		
		List<Sugang> sugangList = jdbcTemplateObject.query(sqlStatement, new SugangMapper());
		return sugangList;
	}
	
	public Sugang getSugangByCourseCode(Integer course_code){
		String sqlStatement = "SELECT sugang_id, course_code, course_name, course_type, course_point "
				+ "FROM sugang "
				+ "WHERE course_code = ?";
		
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{course_code}, new SugangMapper());
	}
	
	public Integer countSugangByCourseCode(String course_code){
		String sqlStatement = "SELECT count(*)"
				+ "FROM sugang "
				+ "WHERE course_code = ?";
		
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[]{course_code}, Integer.class);
	}

}
