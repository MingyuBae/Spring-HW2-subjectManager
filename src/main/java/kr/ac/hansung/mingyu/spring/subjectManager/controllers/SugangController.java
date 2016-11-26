package kr.ac.hansung.mingyu.spring.subjectManager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.mingyu.spring.subjectManager.model.Sugang;
import kr.ac.hansung.mingyu.spring.subjectManager.service.SugangService;

@Controller
@RequestMapping("/sugang")
public class SugangController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
			/* 수강신청이 정상적으로 등록된 경우 */
			return "sugang/success";
		} else {
			return "sugang/addForm";
		}
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String showList(Model model){
		List<Sugang> sugangList = sugangService.getSugangList();
		
		model.addAttribute("sugangList", sugangList);
		
		return "sugang/list";
	}
}
