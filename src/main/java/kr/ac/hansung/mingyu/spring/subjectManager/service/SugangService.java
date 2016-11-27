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
	
	public Sugang removeSugangData(String course_code){
		if(sugangDAO.countSugangByCourseCode(course_code) == 0){
			/* 수강신청 목록에 해당 교과 코드가 없는경우 */
			return null;
		}
		
		Sugang sugangData = sugangDAO.getSugangByCourseCode(course_code);
		
		if(! sugangDAO.delete(sugangData.getSugang_id())){
			/* 수강신청 목록에서 삭제하지 못한 경우 */
			return null;
		}
		
		return sugangData;
	}
	
	public List<Sugang> getSugangList(){
		return sugangDAO.getSugangList();
	}
	
	public List<Sugang> getSugangSummary(){
		List<Sugang> sugangSummaryList = sugangDAO.getSugangSummary();
		
		int pointSum = 0;
		for(Sugang summary: sugangSummaryList){
			pointSum += summary.getCourse_point();
		}
		
		Sugang allSummary = new Sugang();
		allSummary.setCourse_type("총학점");
		allSummary.setCourse_point(pointSum);
		sugangSummaryList.add(allSummary);
		
		return sugangSummaryList;
	}
}
