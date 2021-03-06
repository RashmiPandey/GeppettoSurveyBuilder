package com.geppetto.surveybuilder.mysql;


import java.util.ArrayList;
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
import com.geppetto.surveybuilder.domain.core.Servey_result;



/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
@Transactional
@Repository("Servey_result_Default_ActivityDao")
public class Servey_result_Dao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_servey_result.sql}")
	private String create_servey_result_sql;
	@Value("${servey_result_search_for_update.sql}")
	private String servey_result_search_for_update_sql;
	@Value("${update_servey_result.sql}")
	private String update_servey_result_sql;
	@Value("${delete_servey_result.sql}")
	private String delete_servey_result_sql;
	@Value("${get_all_servey_result.sql}")
	private String get_all_servey_result_sql;
	@Value("${search_servey_result.sql}")
	private String search_servey_result_sql;
	@Value("${servey_result_by_question_and_survey_id.sql}")
	private String servey_result_by_question_and_survey_id_sql;

	

    @PersistenceContext
	EntityManager entityManager;


	//auths not ready at this time
	public Servey_result servey_result_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(servey_result_search_for_update_sql,Servey_result.class)

			.setParameter("id", id);;

			ArrayList<Servey_result> Servey_result_list =	(ArrayList<Servey_result>)result.getResultList();

			if(Servey_result_list  == null){
				throw new Exception("no Servey_result found");
			}

			return (Servey_result) Servey_result_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<Servey_result> get_all_servey_result() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_servey_result_sql,Servey_result.class);

			ArrayList<Servey_result> Servey_result_list =	(ArrayList<Servey_result>)result.getResultList();

			if(Servey_result_list .size() < 1){
				throw new Exception("no Servey_result found");
			}

			return (ArrayList<Servey_result>) Servey_result_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<Servey_result> search_servey_result(String  question_id, String  option_id, String  client_id, String  product_id, String  country_id, String  survey_id, String  user_id, String answer) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(search_servey_result_sql,Servey_result.class)

			.setParameter("question_id", question_id.concat("%"))
			.setParameter("option_id", option_id.concat("%"))
			.setParameter("client_id", client_id.concat("%"))
			.setParameter("product_id", product_id.concat("%"))
			.setParameter("country_id", country_id.concat("%"))
			.setParameter("survey_id", survey_id.concat("%"))
			.setParameter("user_id", user_id.concat("%"))
			.setParameter("answer", answer.concat("%"))
;

			ArrayList<Servey_result> Servey_result_list =	(ArrayList<Servey_result>)result.getResultList();

			if(Servey_result_list  == null){
				throw new Exception("null");
			}

			return (ArrayList<Servey_result>) Servey_result_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public Servey_result create_servey_result(Servey_result Servey_result, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_servey_result_sql)
			.setParameter("question_id", Servey_result.getQuestion_id())
			.setParameter("option_id", Servey_result.getOption_id())
			.setParameter("client_id", Servey_result.getClient_id())
			.setParameter("product_id", Servey_result.getProduct_id())
			.setParameter("country_id", Servey_result.getCountry_id())
			.setParameter("survey_id", Servey_result.getSurvey_id())
			.setParameter("user_id", Servey_result.getUser_id())
			.setParameter("answer", Servey_result.getAnswer());

			query.executeUpdate();

			return Servey_result;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}

	//auths not ready at this time
	@Transactional
	public Servey_result update_servey_result(Servey_result Servey_result, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_servey_result_sql)
			.setParameter("Id", Servey_result.getId())
			.setParameter("question_id", Servey_result.getQuestion_id())
			.setParameter("option_id", Servey_result.getOption_id())
			.setParameter("client_id", Servey_result.getClient_id())
			.setParameter("product_id", Servey_result.getProduct_id())
			.setParameter("country_id", Servey_result.getCountry_id())
			.setParameter("survey_id", Servey_result.getSurvey_id())
			.setParameter("user_id", Servey_result.getUser_id())
			.setParameter("answer", Servey_result.getAnswer())
;

			query.executeUpdate();

			return Servey_result;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}

	//auths not ready at this time
	@Transactional
	public String  delete_servey_result(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_servey_result_sql)
			.setParameter("Id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}

	
	public List<Servey_result> get_servey_result_by_question_and_survey_id(long  question_id, long  survey_id) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(servey_result_by_question_and_survey_id_sql,Servey_result.class)

			.setParameter("question_id", question_id)
			.setParameter("survey_id", survey_id);

			List<Servey_result> Servey_result_list =	(List<Servey_result>)result.getResultList();

			if(Servey_result_list  == null){
				throw new Exception("null");
			}

			return (List<Servey_result>) Servey_result_list;

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}


}