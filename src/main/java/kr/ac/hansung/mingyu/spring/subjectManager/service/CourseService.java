package kr.ac.hansung.mingyu.spring.subjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.mingyu.spring.subjectManager.dao.CourseDAO;
import kr.ac.hansung.mingyu.spring.subjectManager.model.Course;

@Service
public class CourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	public List<Course> getCourseGroupSemester(){
		return courseDAO.getCourseGroupSemester();
	}
	
	
	public List<Course> getCourseBySemester(int course_year, String course_semester){
		
		return courseDAO.getCourseBySemester(course_year, course_semester);
	}
	
	public List<Course> getPointSummaryGroupByType(){
		int sumPoint = 0;
		
		List<Course> result = courseDAO.getPointSummaryGroupByType();
		
		for(Course typeData: result){
			sumPoint += typeData.getCourse_point();
		}
		
		Course sumData = new Course();
		sumData.setCourse_type("총학점");
		sumData.setCourse_point(sumPoint);
		result.add(sumData);
		
		return result;
	}
	
	public List<Course> getPointSummaryGroupByTypeBySemester(int course_year, String course_semester){
		int sumPoint = 0;
		
		List<Course> result = courseDAO.getPointSummaryGroupByTypeBySemester(course_year, course_semester);
		
		for(Course typeData: result){
			sumPoint += typeData.getCourse_point();
		}
		
		Course sumData = new Course();
		sumData.setCourse_type("총학점");
		sumData.setCourse_point(sumPoint);
		result.add(sumData);
		
		return result;
	}
}
