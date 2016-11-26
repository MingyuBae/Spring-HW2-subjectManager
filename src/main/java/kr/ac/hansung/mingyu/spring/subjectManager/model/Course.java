package kr.ac.hansung.mingyu.spring.subjectManager.model;

public class Course {
	private Integer course_year;
	private String course_semester;
	private String course_code;
	private String course_name;
	private String course_type;
	private int course_point;
	
	public Integer getCourse_year() {
		return course_year;
	}
	public void setCourse_year(Integer course_year) {
		this.course_year = course_year;
	}
	public String getCourse_semester() {
		return course_semester;
	}
	public void setCourse_semester(String course_semester) {
		this.course_semester = course_semester;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_type() {
		return course_type;
	}
	public void setCourse_type(String course_type) {
		this.course_type = course_type;
	}
	public int getCourse_point() {
		return course_point;
	}
	public void setCourse_point(int course_point) {
		this.course_point = course_point;
	}
	
	@Override
	public String toString() {
		return "CourseDTO [course_year=" + course_year + ", course_semester=" + course_semester + ", course_code="
				+ course_code + ", course_name=" + course_name + ", course_type=" + course_type + ", course_point="
				+ course_point + "]";
	}
}
