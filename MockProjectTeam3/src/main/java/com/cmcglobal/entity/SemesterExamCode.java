package com.cmcglobal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the semester_exam_code database table.
 * 
 */
@Entity
@Table(name = "semester_exam_code")
@NamedQuery(name = "SemesterExamCode.findAll", query = "SELECT s FROM SemesterExamCode s")
public class SemesterExamCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "semester_exam_codecol")
	private String semesterExamCodecol;

	private int status;

	// bi-directional many-to-one association to SemesterExam
	@ManyToOne
	@JoinColumn(name = "semester_exam_id")
	private SemesterExam semesterExam;

	public SemesterExamCode() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemesterExamCodecol() {
		return this.semesterExamCodecol;
	}

	public void setSemesterExamCodecol(String semesterExamCodecol) {
		this.semesterExamCodecol = semesterExamCodecol;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public SemesterExam getSemesterExam() {
		return this.semesterExam;
	}

	public void setSemesterExam(SemesterExam semesterExam) {
		this.semesterExam = semesterExam;
	}

}