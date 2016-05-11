package com.geppetto.surveybuilder.interfaces.dao;

import java.util.ArrayList;
import java.util.List;

import com.geppetto.surveybuilder.domain.core.Store;
import com.google.common.util.concurrent.ExecutionError;

public interface IStoreDao {

	public ArrayList<Store> search_all_store() throws Exception;
	
	
	public ArrayList<Store> get_all_store_by_route_id(long route_id) throws Exception;
	
	public Store create_Store(Store the_Store) throws Exception;
	
	public Store update_store(Store the_Store)  throws Exception;
	
	public void delete_store(Store the_Store)  throws Exception;
}
