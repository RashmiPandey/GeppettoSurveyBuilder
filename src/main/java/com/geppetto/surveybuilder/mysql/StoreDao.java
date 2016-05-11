package com.geppetto.surveybuilder.mysql;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.geppetto.surveybuilder.domain.core.Store;

import com.geppetto.surveybuilder.interfaces.dao.IStoreDao;

@Transactional
@Repository("StoreDao")
public class StoreDao implements IStoreDao {

	@PersistenceContext
	EntityManager entityManager;

	@Value("${search_all_store.sql}")
	private String search_all_store_sql;

	@Value("${get_all_store_by_route_id.sql}")
	private String get_all_store_by_route_id_sql;
	
	@Value("${create_Store.sql}")
	private String create_Store_sql;
	
	@Value("${update_Store.sql}")
	private String update_Store_sql;

	public ArrayList<Store> search_all_store() throws Exception {

		try {

			Query result = entityManager.createNativeQuery(search_all_store_sql, Store.class);

			ArrayList<Store> Store_list = (ArrayList<Store>) result.getResultList();

			if (Store_list == null) {
				throw new Exception("null");
			}

			return (ArrayList<Store>) Store_list;

		} catch (Exception e) {

			new Exception(e.toString());

		}
		return null;

	}

	@Override
	public ArrayList<Store> get_all_store_by_route_id(long route_id) throws Exception {
		try {
			Query result = entityManager.createNativeQuery(get_all_store_by_route_id_sql, Store.class)
					.setParameter("id", route_id);

			ArrayList<Store> Store_list = (ArrayList<Store>) result.getResultList();

			if (Store_list == null) {
				throw new Exception("null");
			}

			return (ArrayList<Store>) Store_list;

		} catch (Exception e) {

			System.out.println("---exception----dhina--" + e);
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}
		// return null;
	}

	@Override
	public Store create_Store(Store the_Store) throws Exception {

		try {
			Query query = entityManager.createNativeQuery(create_Store_sql,Store.class)
					.setParameter("place", the_Store.getLocation())
					.setParameter("id", the_Store.getRoute_id())
					.setParameter("storeName", the_Store.getStore_name());

			query.executeUpdate();

			return the_Store;

		} catch (Exception e) {

			System.out.println("DAOException: " + e.toString());

		}
		return null;

	}

	public Store update_store(Store the_Store) { 
 
		return entityManager.merge(the_Store);
	}

	@Override
	@Transactional
	public void delete_store(Store the_Store) throws Exception {
		
		entityManager.remove(entityManager.getReference(Store.class, the_Store.getId())); 
	}

}
