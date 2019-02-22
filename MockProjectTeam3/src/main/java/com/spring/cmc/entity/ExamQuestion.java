package com.spring.cmc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the exam_question database table.
 * 
 */
@Entity
@Table(name = "exam_question")
@NamedQuery(name = "ExamQuestion.findAll", query = "SELECT e FROM ExamQuestion e")
public class ExamQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name = "choice_order")
	private String choiceOrder;

	// bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	// bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public ExamQuestion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChoiceOrder() {
		return this.choiceOrder;
	}

	public void setChoiceOrder(String choiceOrder) {
		this.choiceOrder = choiceOrder;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}