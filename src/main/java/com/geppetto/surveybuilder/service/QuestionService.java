package com.geppetto.surveybuilder.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geppetto.surveybuilder.domain.core.GpUser;
import com.geppetto.surveybuilder.domain.core.Question;
import com.geppetto.surveybuilder.domain.core.QuestionTypes;
import com.geppetto.surveybuilder.mysql.QuestionDao;





/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
@Service("QuestionService")
public class QuestionService extends GpBaseService  {


	QuestionDao Question_dao;


	public QuestionDao get_Question_dao() {
		return Question_dao;
	}


	@Resource(name="QuestionDao")
	public void set_Question_dao(QuestionDao Question_dao) {
		this.Question_dao = Question_dao;
	}
	
	public ArrayList<QuestionTypes> get_all_question_types( GpUser user) throws Exception {

		try{
			ArrayList<QuestionTypes> Question_list = new ArrayList<QuestionTypes>();
			Question_list = Question_dao.get_all_question_types(user);
			return Question_list;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	public Map<String, Object> get_all_values_by_survey_id( GpUser user) throws Exception {

		try{
			Map<String, Object> Question_list = new HashMap<String, Object>();
			Question_list = Question_dao.get_all_values_by_survey_id(user);
			return Question_list;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	//auths not ready at this time
	public Question create_question(Question Question, GpUser user) throws Exception {


		try{
			Question the_Question;

			the_Question = Question_dao.create_question(Question, user);

			return the_Question;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}
	
	public Question create_question_new(Question Question, GpUser user) throws Exception {


		try{
			return Question_dao.create_question_new(Question, user);

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}


	//auths not ready at this time
	public String  delete_question(long id, GpUser user) throws Exception {


		try{
			String method_return_message;

			method_return_message = Question_dao.delete_question(id, user);

			return method_return_message;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	//auths not ready at this time
	public Question question_search_for_update(long id, GpUser user) throws Exception {


		try{
			Question the_Question;

			the_Question = Question_dao.question_search_for_update(id, user);

			return the_Question;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	//auths not ready at this time
	public Question update_question(Question Question, GpUser user) throws Exception {


		try{
			Question the_Question;

			the_Question = Question_dao.update_question(Question, user);

			return the_Question;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<Question> search_question(String  The_question, String  Display_type, String  Answer_id, String  Order_in_survey, String  Group_name, String  Group_id, String  Rank_importance, String  Created_by, String  Created_date, String  Updated_by, String  Updated_date, String  Survey_id) throws Exception {


		try{
			ArrayList<Question> Question_list;

			Question_list = Question_dao.search_question(The_question,Display_type,Answer_id,Order_in_survey,Group_name,Group_id,Rank_importance,Created_by,Created_date,Updated_by,Updated_date,Survey_id);

			return Question_list;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}

	public List<Question> get_question_by_survey_id(long survey_id) throws Exception {


		try{

			return Question_dao.get_question_by_survey_id(survey_id);


		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;


	}


	public ArrayList<Question> get_all_question_by_survey_id(long survey_id) {
		return Question_dao.get_all_question_by_survey_id(survey_id);
	}


}