package com.wura.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wura.dojoOverflow.models.Answer;
import com.wura.dojoOverflow.models.Question;
import com.wura.dojoOverflow.models.Tag;
import com.wura.dojoOverflow.repositories.AnswerRepository;
import com.wura.dojoOverflow.repositories.QuestionRepository;
import com.wura.dojoOverflow.repositories.TagRepository;

@Service
public class DojoService {
	private QuestionRepository questionRepo;
	private TagRepository tagRepo;
	private AnswerRepository answerRepo;
	
	public DojoService (QuestionRepository questionRepo, TagRepository tagRepo, AnswerRepository answerRepo) {
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
		this.answerRepo = answerRepo;
	}
	
	public List<Question> allQuestions() {
		return (List<Question>) questionRepo.findAll();
	}
	public List<Tag> allTags() {
		return (List<Tag>) tagRepo.findAll();
	}
	public List<String> allTagNames() {
		List<String> result = new ArrayList<>();
		for(Tag val:tagRepo.findAll()) {
			result.add(val.getName());
		}
		return result;
	}
	public Question addQuestion(Question question) {
		return questionRepo.save(question);
	}
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public void addQuestionTag(Question question, Tag tag) {
		question.getTags().add(tag);
		questionRepo.save(question);
		tagRepo.save(tag);
	}
	public Tag findTagByName(String tag) {
		for(Tag val:tagRepo.findAll()) {
			if(val.getName().equals(tag)) {
				return val;
			} 
		}
		return null;
	}
	public Answer addAnswer(Answer answer) {
		return answerRepo.save(answer);
	
	}
	public void addAnswerToQuestion(Answer answer, Question question) {
		answer.setQuestion(question);
		answerRepo.save(answer);

	}
	public Question findQuestion(Long id) {
		return questionRepo.findOne(id);
	}
	public List<Answer> findAnswer() {
		return (List<Answer>) answerRepo.findAll();
	}
	
}
