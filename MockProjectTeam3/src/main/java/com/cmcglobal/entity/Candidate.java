package com.cmcglobal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "candidate_id")
	private int candidateId;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("candidates")
	private User user;

	// bi-directional many-to-one association to SemesterExam
	@ManyToOne
	@JoinColumn(name = "semester_exam_id")
	private SemesterExam semesterExam;

	// bi-directional many-to-one association to CandidateTest
	@OneToMany(mappedBy = "candidate")
	private List<CandidateTest> candidateTests;

	public Candidate() {
	}

	public int getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SemesterExam getSemesterExam() {
		return this.semesterExam;
	}

	public void setSemesterExam(SemesterExam semesterExam) {
		this.semesterExam = semesterExam;
	}

	public List<CandidateTest> getCandidateTests() {
		return this.candidateTests;
	}

	public void setCandidateTests(List<CandidateTest> candidateTests) {
		this.candidateTests = candidateTests;
	}

	public CandidateTest addCandidateTest(CandidateTest candidateTest) {
		getCandidateTests().add(candidateTest);
		candidateTest.setCandidate(this);

		return candidateTest;
	}

	public CandidateTest removeCandidateTest(CandidateTest candidateTest) {
		getCandidateTests().remove(candidateTest);
		candidateTest.setCandidate(null);

		return candidateTest;
	}

}