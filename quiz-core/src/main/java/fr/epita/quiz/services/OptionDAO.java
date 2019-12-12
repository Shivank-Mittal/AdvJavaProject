package fr.epita.quiz.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import fr.epita.quiz.datamodel.Options;

public class OptionDAO extends DAO<Options> {

	@Override
	protected String getAllQueryString() {
		// TODO Auto-generated method stub
		return "from Options q where q.questionId = :QuestionID";
	}

	@Override
	protected String getSearchQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Options options) {
		// TODO Auto-generated method stub
		System.out.println("questionRef::"+options.getQuestionId());
		map.put("QuestionID", options.getQuestionId());
	}

	
	 
	 

}
