package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Options")
public class Options {
	
	public  Options() {
	}
	public Options( int Questionid, String Option, boolean CorrectOption) {
		this.questionId=Questionid;
		this.options= Option;
		this.correctOption= CorrectOption;
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	

	@Column(name="Question_ID")
	private int questionId;
	
	@Column(name="Options")
	private String options;
	
	@Column(name="CorrectOption")
	private boolean correctOption;

	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public boolean isCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(boolean correctOption) {
		this.correctOption = correctOption;
	}
	public Integer getId() {
		return id;
	}

}
