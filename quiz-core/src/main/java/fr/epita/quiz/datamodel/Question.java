package fr.epita.quiz.datamodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	
	@Column(name="CONTENT")
	private String questionContent;

	
	public Question() {

	}

	public Question(String questionContent) {
		this.questionContent = questionContent;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestionContent() {
		return questionContent;
	}


	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	

}
