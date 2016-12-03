package kr.ac.hansung.mingyu.spring.subjectManager.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Course;
import kr.ac.hansung.mingyu.spring.subjectManager.service.CourseService;

/**
 * index, 이수 학점 조회를 담당하는 Controller
 * @author MingyuBae
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * index 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
	}
	
	/**
	 * 학기별 이수학점 조회
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/semesterSummary", method = RequestMethod.GET)
	public String getCourseBySemesterGet(Model model){
		List<Course> semesterInfoList = courseService.getCourseGroupSemester();
		
		model.addAttribute("semesterInfoList", semesterInfoList);
		
		return "semesterSummary";
	}
	
	/**
	 * 학기별 이수학점 조회 상세 페이지
	 * @param year 조회할 수강년도
	 * @param semester 조회할 학기
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/semesterDetail", method = RequestMethod.GET)
	public String getCourseBySemester(Integer year, String semester, Model model){
		List<Course> courseList = courseService.getCourseBySemester(year, semester);
		List<Course> summaryList = courseService.getPointSummaryGroupByTypeBySemester(year, semester);
		
		model.addAttribute("year", year);
		model.addAttribute("semester", semester);
		model.addAttribute("courseList", courseList);
		model.addAttribute("summaryList", summaryList);
		
		return "semesterDetail";
	}
	
	/**
	 * 이수 구분별 학점 조회 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/pointSummary", method = RequestMethod.GET)
	public String getPointSummaryGroupByType(Model model){
		List<Course> summaryList = courseService.getPointSummaryGroupByType();
		
		model.addAttribute("summaryList", summaryList);
		
		return "pointSummary";
	}
	
}
