package kr.ac.hansung.mingyu.spring.subjectManager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Course;

public class CourseMapper implements RowMapper<Course>{
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		
		course.setCourse_year(rs.getInt("course_year"));
		course.setCourse_semester(rs.getString("course_semester"));
		course.setCourse_code(rs.getString("course_code"));
		course.setCourse_name(rs.getString("course_name"));
		course.setCourse_type(rs.getString("course_type"));
		course.setCourse_point(rs.getInt("course_point"));
		
		return course;
	}
}
