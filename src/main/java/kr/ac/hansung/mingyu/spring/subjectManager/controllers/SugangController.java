package kr.ac.hansung.mingyu.spring.subjectManager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Sugang;
import kr.ac.hansung.mingyu.spring.subjectManager.service.SugangService;


/**
 * 수강신청 Controller
 * @author MingyuBae
 *
 */
@Controller
@RequestMapping("/sugang")
public class SugangController {
	
	@Autowired
	SugangService sugangService;
	
	/**
	 * 수강신청 폼
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addSugangForm(Model model){
		model.addAttribute("sugang", new Sugang());
		return "sugang/addForm";
	}
	
	
	/**
	 * 수강신청 처리
	 * @param model
	 * @param sugang 사용자가 입력한 수강신청 내용
	 * @param result 검증 결과
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSugang(Model model, @Valid Sugang sugang, BindingResult result){
		
		if(! result.hasErrors() && sugangService.addSugangData(sugang, result)){
			return "sugang/addSuccess";
		} else {
			return "sugang/addForm";
		}
	}
	
	/**
	 * 신청한 수강신청 삭제
	 * @param model
	 * @param course_code 삭제할 수강신청 교과코드
	 * @return
	 */
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteSugang(Model model, String course_code){
		Sugang sugang = sugangService.removeSugangData(course_code);
		
		if(sugang != null){
			model.addAttribute("sugang", sugang);
			return "sugang/removeSuccess";
		} else {
			return "sugang/removeFail";
		}
	}
	
	/**
	 * 수강신청 목록 조회
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(Model model){
		List<Sugang> sugangList = sugangService.getSugangList();
		List<Sugang> summaryList = sugangService.getSugangSummary();
		
		model.addAttribute("sugangList", sugangList);
		model.addAttribute("summaryList", summaryList);
		
		return "sugang/list";
	}
}
