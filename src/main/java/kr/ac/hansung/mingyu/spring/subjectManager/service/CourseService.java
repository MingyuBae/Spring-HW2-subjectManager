package kr.ac.hansung.mingyu.spring.subjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.mingyu.spring.subjectManager.dao.CourseDAO;
import kr.ac.hansung.mingyu.spring.subjectManager.model.Course;

/**
 * 이수학점 Service
 * @author MingyuBae
 *
 */
@Service
public class CourseService {
	@Autowired
	private CourseDAO courseDAO;
	
	/**
	 * 학기별 이수학점 조회
	 */
	public List<Course> getCourseGroupSemester(){
		return courseDAO.getCourseGroupSemester();
	}
	
	/**
	 * 해당학기의 이수 교과목 조회
	 * @param course_year 이수년도
	 * @param course_semester 이수학기
	 * @return 해당 학기에 수강한 교과목 리스트
	 */
	public List<Course> getCourseBySemester(int course_year, String course_semester){
		
		return courseDAO.getCourseBySemester(course_year, course_semester);
	}
	
	/**
	 * 이수 구분별 이수학점 조회
	 */
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
	
	/**
	 * 해당 학기의 이수 구분별 이수학점 조회
	 * @param course_year 이수년도
	 * @param course_semester 이수학기
	 */
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
