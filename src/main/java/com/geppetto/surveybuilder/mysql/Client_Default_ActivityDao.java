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

import com.geppetto.surveybuilder.domain.core.Client;
import com.geppetto.surveybuilder.domain.core.GpUser;


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
@Repository("Client_Default_ActivityDao")
public class Client_Default_ActivityDao   {

	private Log log = LogFactory.getLog(getClass());

	@Value("${create_client.sql}")
	private String create_client_sql;
	@Value("${client_search_for_update.sql}")
	private String client_search_for_update_sql;
	@Value("${update_client.sql}")
	private String update_client_sql;
	@Value("${delete_client.sql}")
	private String delete_client_sql;
	@Value("${get_all_client.sql}")
	private String get_all_client_sql;


    @PersistenceContext
	EntityManager entityManager;


	//auths not ready at this time
	public Client client_search_for_update(long id, GpUser user) throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(client_search_for_update_sql,Client.class)

			.setParameter("id", id);;

			ArrayList<Client> Client_list =	(ArrayList<Client>)result.getResultList();

			if(Client_list  == null){
				throw new Exception("no Client found");
			}

			return (Client) Client_list.get(0);

		}catch(Exception e){

			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}

	//auths not ready at this time
	public ArrayList<Client> get_all_client() throws Exception {


		try{

			Query result =  entityManager.
			createNativeQuery(get_all_client_sql,Client.class);

			ArrayList<Client> Client_list =	(ArrayList<Client>)result.getResultList();

			if(Client_list .size() < 1){
				throw new Exception("no Client found");
			}

			return (ArrayList<Client>) Client_list;

		}catch(Exception e){
			System.out.println("DAOException: " + e.toString());
			new Exception(e.toString());  // this needs to be changed 

		}
		return null;


	}



	//auths not ready at this time
	@Transactional
	public Client create_client(Client Client, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(create_client_sql)
			.setParameter("Client_id", Client.getClient_id())
			.setParameter("Client_name", Client.getClient_name())
			.setParameter("Notes", Client.getNotes())
			.setParameter("Createdby", Client.getCreatedby())
			.setParameter("Create_Date", Client.getCreate_Date())
			.setParameter("Modifiedby", Client.getModifiedby())
			.setParameter("Modified_Date", Client.getModified_Date())
;

			query.executeUpdate();

			return Client;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}

	//auths not ready at this time
	@Transactional
	public Client update_client(Client Client, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(update_client_sql)
			.setParameter("Id", Client.getId())
			.setParameter("Client_id", Client.getClient_id())
			.setParameter("Client_name", Client.getClient_name())
			.setParameter("Notes", Client.getNotes())
			.setParameter("Createdby", Client.getCreatedby())
			.setParameter("Create_Date", Client.getCreate_Date())
			.setParameter("Modifiedby", Client.getModifiedby())
			.setParameter("Modified_Date", Client.getModified_Date())
;

			query.executeUpdate();

			return Client;

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}

	//auths not ready at this time
	@Transactional
	public String  delete_client(long id, GpUser user) throws Exception {


		try{
			Query query = entityManager
					.createNativeQuery(delete_client_sql)
			.setParameter("Id", id);

			query.executeUpdate();

			return "{\"status\":\"success\"}";

		}catch(Exception e){

			System.out.println("DAOException: " + e.toString()); 

		}
		return null;


	}



}