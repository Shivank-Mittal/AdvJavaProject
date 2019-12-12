package fr.epita.quiz.services;

import java.util.Map;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Question;

@Repository
public class QuestionDAO extends DAO<Question>{

	@Override
	protected String getSearchQueryString() {
		
			return "from Question q where q.questionContent like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String,Object> map, Question question) {
		map.put("pContent", "%" + question.getQuestionContent() + "%");

	}

	@Override
	protected String getAllQueryString() {	
		return "from Question q";		
	}

}
