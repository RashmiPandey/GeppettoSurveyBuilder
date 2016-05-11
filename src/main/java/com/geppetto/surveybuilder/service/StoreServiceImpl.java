package com.geppetto.surveybuilder.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geppetto.surveybuilder.domain.core.Product;
import com.geppetto.surveybuilder.domain.core.Store;
import com.geppetto.surveybuilder.interfaces.service.StoreService;
import com.geppetto.surveybuilder.mysql.StoreDao;

@Service("StoreServiceImpl")
public class StoreServiceImpl implements StoreService {

	StoreDao storeDao;

	public StoreDao getStoreDao() {
		return storeDao;
	}

	@Resource(name = "StoreDao")
	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	public ArrayList<Store> search_all_store() throws Exception {

		try {
			ArrayList<Store> store_list;

			store_list = storeDao.search_all_store();

			return store_list;

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}
		return null;

	}

	@Override
	public ArrayList<Store> get_all_store_by_route_id(long route_id) throws Exception {
		try {
			ArrayList<Store> store_list;

			store_list = storeDao.get_all_store_by_route_id(route_id);

			return store_list;

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}
		return null;
	}

	public Store create_Store(Store the_Store) {
		try {
			Store store;

			store = storeDao.create_Store(the_Store);

			return store;

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}
		return null;
	}

	public Store update_Store(Store the_Store) {
		try {
			Store store;

			store = storeDao.update_store(the_Store);

			return store;

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}
		return null;
	}

	public void delete_store(Store the_Store) {

		try {
			storeDao.delete_store(the_Store);

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}

	}

}
