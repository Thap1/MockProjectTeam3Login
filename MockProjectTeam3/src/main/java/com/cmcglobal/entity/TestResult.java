package com.cmcglobal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test_result database table.
 * 
 */
@Entity
@Table(name="test_result")
@NamedQuery(name="TestResult.findAll", query="SELECT t FROM TestResult t")
public class TestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_result_id")
	private int testResultId;

	@Column(name="answer_id")
	private String answerId;

	@Column(name="test_id")
	private int testId;

	//bi-directional many-to-one association to CandidateTest
	@ManyToOne
	@JoinColumn(name="candidate_test_id")
	private CandidateTest candidateTest;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;

	public TestResult() {
	}

	public int getTestResultId() {
		return this.testResultId;
	}

	public void setTestResultId(int testResultId) {
		this.testResultId = testResultId;
	}

	public String getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public CandidateTest getCandidateTest() {
		return this.candidateTest;
	}

	public void setCandidateTest(CandidateTest candidateTest) {
		this.candidateTest = candidateTest;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}