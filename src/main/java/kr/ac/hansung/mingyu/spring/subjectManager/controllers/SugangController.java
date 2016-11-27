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

@Controller
@RequestMapping("/sugang")
public class SugangController {
	
	@Autowired
	SugangService sugangService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addSugangForm(Model model){
		model.addAttribute("sugang", new Sugang());
		return "sugang/addForm";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSugang(Model model, @Valid Sugang sugang, BindingResult result){
		
		if(! result.hasErrors() && sugangService.addSugangData(sugang, result)){
			return "sugang/addSuccess";
		} else {
			return "sugang/addForm";
		}
	}
	
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
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(Model model){
		List<Sugang> sugangList = sugangService.getSugangList();
		List<Sugang> summaryList = sugangService.getSugangSummary();
		
		model.addAttribute("sugangList", sugangList);
		model.addAttribute("summaryList", summaryList);
		
		return "sugang/list";
	}
}
