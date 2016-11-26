package kr.ac.hansung.mingyu.spring.subjectManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import kr.ac.hansung.mingyu.spring.subjectManager.dao.SugangDAO;
import kr.ac.hansung.mingyu.spring.subjectManager.model.Sugang;

@Service
public class SugangService {
	@Autowired
	SugangDAO sugangDAO;
	
	public boolean addSugangData(Sugang sugangData, BindingResult result){
		if(sugangDAO.countSugangByCourseCode(sugangData.getCourse_code()) != 0){
			/* 이미 같은 코드를 가진 수강신청 항목이 있을때 */
			result.addError(new FieldError("sugang", "course_code", "이미 신청한 강의코드입니다."));
			return false;
		}
		
		return sugangDAO.insert(sugangData);
	}
	
	public List<Sugang> getSugangList(){
		return sugangDAO.getSugangList();
	}
}
