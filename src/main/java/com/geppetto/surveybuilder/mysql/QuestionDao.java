package com.geppetto.surveybuilder.mysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Transient;
import javax.sound.midi.SysexMessage;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.Transactional;
import javax.persistence.Query;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.geppetto.surveybuilder.domain.core.GpUser;
import com.geppetto.surveybuilder.domain.core.Option;
import com.geppetto.surveybuilder.domain.core.Product;
import com.geppetto.surveybuilder.domain.core.Question;
import com.geppetto.surveybuilder.domain.core.QuestionTypes;
import com.geppetto.surveybuilder.domain.core.Survey;

/**
 * 
 * @author Geppetto Generated Code</br> Date Created: </br>
 * @since </br> build: </p>
 *
 *        code was generated by the Geppetto System </br> Gepppetto system
 *        Copyright - Geppetto LLC 2014 - 2015</br> The generated code is free
 *        to use by anyone</p>
 *
 *
 *
 */
@Transactional
@Repository("QuestionDao")
public class QuestionDao {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_question.sql}")
	private String create_question_sql;
	@Value("${delete_question.sql}")
	private String delete_question_sql;

	@Value("${question_search_for_update.sql}")
	private String question_search_for_update_sql;

	@Value("${update_question.sql}")
	private String update_question_sql;
	@Value("${search_question.sql}")
	private String search_question_sql;

	@Value("${get_all_values_by_survey_id.sql}")
	private String get_all_values_by_survey_id_sql;

	@Value("${option.sql}")
	private String get_all_options_by_question_id_sql;

	@Value("${get_all_survey.sql}")
	private String get_all_survey_sql;

	@Value("${get_all_question_types.sql}")
	private String get_all_question_types_sql;

	private OptionDao option_dao;

	@PersistenceContext
	EntityManager entityManager;

	// auths not ready at this time
	public ArrayList<QuestionTypes> get_all_question_types(GpUser user)
			throws Exception {

		try {

			Query QuestionTypeResult = entityManager.createNativeQuery(
					get_all_question_types_sql, QuestionTypes.class);
			@SuppressWarnings("unchecked")
			ArrayList<QuestionTypes> QuestionTypeList = (ArrayList<QuestionTypes>) QuestionTypeResult
					.getResultList();
			System.out.println("QuestionTypeList : " + QuestionTypeList.size());
			return QuestionTypeList;
		} catch (Exception e) {

			new Exception(e.toString());

		}
		return null;

	}

	// auths not ready at this time
	public Map<String, Object> get_all_values_by_survey_id(GpUser user)
			throws Exception {

		try {

			Query survey_result = entityManager.createNativeQuery(
					get_all_survey_sql, Survey.class);
			ArrayList<Survey> Survey_list = (ArrayList<Survey>) survey_result
					.getResultList();
			System.out.println("Survey_list size : " + Survey_list.size());

			for (Survey survey : Survey_list) {
				long survey_id = survey.getId();
				Query result = entityManager.createNativeQuery(
						get_all_values_by_survey_id_sql, Question.class)
						.setParameter("survey_id", survey_id);
				// System.out.println("id :" + id);
				ArrayList<Question> Question_list = (ArrayList<Question>) result
						.getResultList();
				System.out.println("Question_list size : "
						+ Question_list.size());
				// survey list

				for (Question question : Question_list) {
					long question_id = question.getId();
					Query result_options = entityManager.createNativeQuery(
							get_all_options_by_question_id_sql, Option.class)
							.setParameter("id", question_id);
					ArrayList<Option> Option_list = (ArrayList<Option>) result_options
							.getResultList();
					System.out.println("Option_list size : "
							+ Option_list.size());
					/*
					 * for (Option option : Option_list) {
					 * System.out.println("Option "+option.toString()); }
					 */
					question.setOptions(Option_list);
				}

				survey.setQuestion(Question_list);
			}

			ArrayList<Survey> survey_create = new ArrayList<Survey>();
			ArrayList<Survey> survey_update = new ArrayList<Survey>();
			ArrayList<Survey> survey_delete = new ArrayList<Survey>();
			ArrayList<Survey> survey_sync = new ArrayList<Survey>();
			Map<String, Object> the_map = new HashMap<String, Object>();

			for (Survey survey : Survey_list) {
				if (survey.getStatus().equals("C")) {
					survey_create.add(survey);

				} else if (survey.getStatus().equals("D")) {
					survey_delete.add(survey);

				} else if (survey.getStatus().equals("U")) {
					survey_update.add(survey);

				} else if (survey.getStatus().equals("S")) {
					survey_sync.add(survey);

				}

			}

			the_map.put("create", survey_create);
			the_map.put("update", survey_update);
			the_map.put("delete", survey_delete);
			the_map.put("sync", survey_sync);

			return (Map<String, Object>) the_map;

		} catch (Exception e) {

			new Exception(e.toString());

		}
		return null;

	}

	// auths not ready at this time
	public Question question_search_for_update(long id, GpUser user)
			throws Exception {

		try {

			Query result = entityManager.createNativeQuery(
					question_search_for_update_sql, Question.class)

			.setParameter("id", id);

			ArrayList<Question> Question_list = (ArrayList<Question>) result
					.getResultList();

			if (Question_list == null) {
				throw new Exception("no Question found");
			}

			return (Question) Question_list.get(0);

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	// auths not ready at this time
	public ArrayList<Question> search_question(String The_question,
			String Display_type, String Answer_id, String Order_in_survey,
			String Group_name, String Group_id, String Rank_importance,
			String Created_by, String Created_date, String Updated_by,
			String Updated_date, String Survey_id) throws Exception {

		try {

			Query result = entityManager
					.createNativeQuery(search_question_sql, Question.class)

					.setParameter("the_question", The_question.concat("%"))
					.setParameter("display_type", Display_type.concat("%"))
					.setParameter("answer_id", Answer_id.concat("%"))
					.setParameter("order_in_survey",
							Order_in_survey.concat("%"))
					.setParameter("group_name", Group_name.concat("%"))
					.setParameter("group_id", Group_id.concat("%"))
					.setParameter("rank_importance",
							Rank_importance.concat("%"))
					.setParameter("created_by", Created_by.concat("%"))
					.setParameter("created_date", Created_date.concat("%"))
					.setParameter("updated_by", Updated_by.concat("%"))
					.setParameter("updated_date", Updated_date.concat("%"))
					.setParameter("survey_id", Survey_id.concat("%"));

			ArrayList<Question> Question_list = (ArrayList<Question>) result
					.getResultList();

			if (Question_list == null) {
				throw new Exception("null");
			}

			return (ArrayList<Question>) Question_list;

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	public List<Question> get_question_by_survey_id(long survey_id)
			throws Exception {

		try {

			Query result = entityManager.createNativeQuery(
					get_all_values_by_survey_id_sql, Question.class)

			.setParameter("survey_id", survey_id);

			List<Question> Question_list = (List<Question>) result
					.getResultList();

			if (Question_list == null) {
				throw new Exception("null");
			}

			return (List<Question>) Question_list;

		} catch (Exception e) {

			new Exception(e.toString()); // this needs to be changed

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public Question create_question(Question Question, GpUser user)
			throws Exception {

		Date date = new Date();
		System.out.println(" date : " + date);
		// / here i give default value;

		/*
		 * created_by : '', created_date : '', updated_by : '', updated_date :
		 * '', survey_id : ''
		 */
		try {
			Query query = entityManager
					.createNativeQuery(create_question_sql)
					.setParameter("the_question", Question.getThe_question())
					.setParameter("display_type", Question.getDisplay_type())
					.setParameter("answer_id", Question.getAnswer_id())
					.setParameter("order_in_survey",
							Question.getOrder_in_survey())
					.setParameter("group_name", Question.getGroup_name())
					.setParameter("group_id", Question.getGroup_id())
					.setParameter("rank_importance",
							Question.getRank_importance())
					.setParameter("created_by", 1)
					.setParameter("created_date", date)
					.setParameter("updated_by", 1)
					.setParameter("updated_date", date)
					.setParameter("survey_id", Question.getSurvey_id())
					.setParameter("type_id", 1);
			query.executeUpdate();

			String lastIndex = "select last_insert_id()";
			Query sql = entityManager.createNativeQuery(lastIndex);
			BigInteger Id = (BigInteger) sql.getSingleResult();
			Question.setId(Long.valueOf(Id.toString()));
			List<Option> options = Question.getOptions();
			for (Option option : options) {
				option.setQuestion_id(Question.getId());
				option_dao.create_option(option, null);
			}

			return Question;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	@Transactional
	public Question create_question_new(Question Question, GpUser user)
			throws Exception {

		Date date = new Date();
		try {
			Query query = entityManager
					.createNativeQuery(create_question_sql)
					.setParameter("the_question", Question.getThe_question())
					.setParameter("survey_id", Question.getSurvey_id())
					.setParameter("type_id", Question.getType_id())
					.setParameter("display_type", Question.getDisplay_type())

					.setParameter("answer_id", Question.getAnswer_id())
					.setParameter("order_in_survey",
							Question.getOrder_in_survey())
					.setParameter("group_name", Question.getGroup_name())
					.setParameter("group_id", Question.getGroup_id())
					.setParameter("rank_importance",
							Question.getRank_importance())
					.setParameter("created_by", ( user == null? 1 : user.getId()) )
					.setParameter("created_date", date)
					.setParameter("updated_by", ( user == null? 1 : user.getId()))
					.setParameter("updated_date", date);
			query.executeUpdate();

			String lastIndex = "select last_insert_id()";
			Query sql = entityManager.createNativeQuery(lastIndex);
			BigInteger Id = (BigInteger) sql.getSingleResult();
			Question.setId(Long.valueOf(Id.toString()));

			return Question;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public String delete_question(long id, GpUser user) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(delete_question_sql)
					.setParameter("id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	// auths not ready at this time
	@Transactional
	public Question update_question(Question Question, GpUser user)
			throws Exception {

		try {
			Query query = entityManager
					.createNativeQuery(update_question_sql)
					.setParameter("id", Question.getId())
					.setParameter("the_question", Question.getThe_question())
					.setParameter("display_type", Question.getDisplay_type())
					.setParameter("answer_id", Question.getAnswer_id())
					.setParameter("order_in_survey",
							Question.getOrder_in_survey())
					.setParameter("group_name", Question.getGroup_name())
					.setParameter("group_id", Question.getGroup_id())
					.setParameter("rank_importance",
							Question.getRank_importance())
					.setParameter("created_by", Question.getCreated_by())
					.setParameter("created_date", Question.getCreated_date())
					.setParameter("updated_by", Question.getUpdated_by())
					.setParameter("updated_date", Question.getUpdated_date())
					.setParameter("survey_id", Question.getSurvey_id());

			query.executeUpdate();

			List<Option> options = Question.getOptions();
			for (Option option : options) {
				option_dao.update_option(option, null);
			}

			return Question;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	public ArrayList<Question> get_all_question_by_survey_id(long survey_id) {
		Query result = entityManager.createNativeQuery(
				get_all_values_by_survey_id_sql, Question.class).setParameter(
				"survey_id", survey_id);
		// System.out.println("id :" + id);
		ArrayList<Question> Question_list = (ArrayList<Question>) result
				.getResultList();
		for (Question question : Question_list) {
			long question_id = question.getId();
			Query result_options = entityManager.createNativeQuery(
					get_all_options_by_question_id_sql, Option.class)
					.setParameter("id", question_id);
			ArrayList<Option> Option_list = (ArrayList<Option>) result_options
					.getResultList();
			question.setOptions(Option_list);
		}
		return Question_list;
	}

	public OptionDao getOption_dao() {
		return option_dao;
	}

	@Resource(name = "OptionDao")
	public void setOption_dao(OptionDao option_dao) {
		this.option_dao = option_dao;
	}
}