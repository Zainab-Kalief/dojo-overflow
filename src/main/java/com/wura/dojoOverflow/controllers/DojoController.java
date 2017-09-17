package com.wura.dojoOverflow.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wura.dojoOverflow.models.Answer;
import com.wura.dojoOverflow.models.Question;
import com.wura.dojoOverflow.models.Tag;
import com.wura.dojoOverflow.models.TagList;
import com.wura.dojoOverflow.services.DojoService;

@Controller
@RequestMapping("/questions")
public class DojoController {
	private final DojoService service;
	public DojoController(DojoService service) {
		this.service = service;
	}
	
	@RequestMapping("")
	public String questions(Model model) {
		model.addAttribute("questions", service.allQuestions());
		return "questions";
	}
	@RequestMapping("/new")
	public String addQuestionPage(@ModelAttribute("newQuestion") Question question) {
		return "newQuestion";
	}
	@PostMapping("/new")
	public String addQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result, @RequestParam(value="tagList") String tags) {
		if(result.hasErrors()) {
			return "newQuestion";
		}
		TagList list = new TagList(tags);
		Question savedQuestion = service.addQuestion(question);
		for(String val:list.getTags()) {
			if(service.allTagNames().contains(val) == false) {
				Tag savedTag = service.addTag(new Tag(val));
				service.addQuestionTag(savedQuestion, savedTag);
			} else {
				service.addQuestionTag(savedQuestion, service.findTagByName(val));
			}
		}
		return "redirect:/questions/new";
	}
	@RequestMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer) {
		model.addAttribute("question", service.findQuestion(id));
		for(Answer val:service.findQuestion(id).getAnswers()) {
			System.out.println(val.getAnswer());
		}
		
		return "question";
	}
	@PostMapping("/{id}")
	public String addAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", service.findQuestion(id));
			return "question";
		}
		
		Answer ans = service.addAnswer(new Answer(answer.getAnswer()));
		service.addAnswerToQuestion(ans, service.findQuestion(id));
		
		return "redirect:/questions/{id}";
	}
}
