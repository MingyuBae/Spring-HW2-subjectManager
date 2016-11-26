package kr.ac.hansung.mingyu.spring.subjectManager.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Course;

@Repository
public class CourseDAO {
	private JdbcTemplate jdbcTemplateObject;
	
	public List<Course> getCourseGroupSemester(){
		String sqlStatement = "SELECT course_year, course_semester, SUM(course_point) "
							+ "FROM course "
							+ "GROUP BY course_year, course_semester "
							+ "ORDER BY course_year, course_semester";
		List<Course> courseList = jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				
				course.setCourse_year(rs.getInt("course_year"));
				course.setCourse_semester(rs.getString("course_semester"));
				course.setCourse_point(rs.getInt("SUM(course_point)"));
				
				return course;
			}
		});
		
		return courseList;
	}
	
	public List<Course> getCourseBySemester(int course_year, String course_semester){
		String sqlStatement = "SELECT course_year, course_semester, course_code, course_name, course_type, course_point " 
							+ "FROM course " 
							+ "WHERE course_year = ? AND course_semester = ?";
		
		List<Course> courseList = jdbcTemplateObject.query(sqlStatement, new Object[]{course_year, course_semester}, new CourseMapper());
		
		return courseList;
	}
	
	public List<Course> getPointSummaryGroupByType(){
		String sqlStatement = "SELECT course_type, SUM(course_point) "
							+ "FROM course "
							+ "GROUP BY course_type";

		List<Course> courseList = jdbcTemplateObject.query(sqlStatement, new RowMapper<Course>(){
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				
				course.setCourse_type(rs.getString("course_type"));
				course.setCourse_point(rs.getInt("SUM(course_point)"));
				
				return course;
			}
		});
		
		return courseList;
	}
	
	
	public List<Course> getPointSummaryGroupByTypeBySemester(int course_year, String course_semester){
		String sqlStatement = "SELECT course_type, SUM(course_point) "
							+ "FROM course "
							+ "WHERE course_year = ? AND course_semester = ?"
							+ "GROUP BY course_type";
		
		List<Course> courseList = jdbcTemplateObject.query(sqlStatement, new Object[]{course_year, course_semester}, new RowMapper<Course>(){

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				
				course.setCourse_type(rs.getString("course_type"));
				course.setCourse_point(rs.getInt("SUM(course_point)"));
				
				return course;
			}
			
		});
		
		return courseList;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}	
}
