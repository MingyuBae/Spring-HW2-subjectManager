package kr.ac.hansung.mingyu.spring.subjectManager.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Sugang {
	private Integer sugang_id;
	
	@Size(min=5, max=10, message="5~10자만 입력할 수 있습니다.")
	@NotEmpty(message="강의코드는 필수 입력 항목입니다")
	private String course_code;
	
	@Size(min=1, max=100, message="1~100자만 입력할 수 있습니다.")
	@NotEmpty(message="강의명은 필수 입력 항목입니다")
	private String course_name;
	
	@Size(min=1, max=10, message="5~10자만 입력할 수 있습니다.")
	@NotEmpty(message="이수구분은 필수 입력 항목입니다")
	private String course_type;
	
	@Max(value=10, message="학점은 10학점 이상 입력할 수 없습니다")
	@Min(value=1, message="학점은 1학점 이하로 입력할 수 없습니다")
	@NotNull(message="학점은 필수 입력 항목입니다")
	private Integer course_point;
	
	public Integer getSugang_id() {
		return sugang_id;
	}
	public void setSugang_id(Integer sugang_id) {
		this.sugang_id = sugang_id;
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
	public Integer getCourse_point() {
		return course_point;
	}
	public void setCourse_point(Integer course_point) {
		this.course_point = course_point;
	}
	
	@Override
	public String toString() {
		return "SugangDTO [sugang_id=" + sugang_id + ", course_code=" + course_code + ", course_name=" + course_name
				+ ", course_type=" + course_type + ", course_point=" + course_point + "]";
	}
}
