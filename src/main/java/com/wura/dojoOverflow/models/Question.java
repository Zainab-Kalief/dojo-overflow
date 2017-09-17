package com.wura.dojoOverflow.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@Size(min = 2, max = 2000)
	private String question;

	@OneToMany(mappedBy="question", fetch=FetchType.LAZY)
	private List<Answer> answers = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="questions_tags",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name = "tag_id")
			)
	private List<Tag> tags = new ArrayList<>();
	
	public Question() {}
	public Question(String question) {
		this.question = question;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
