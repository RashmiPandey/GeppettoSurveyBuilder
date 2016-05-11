package com.geppetto.surveybuilder.interfaces.dao;

import java.util.ArrayList;

import com.geppetto.surveybuilder.domain.core.Route;

public interface IRouteDao {

	public ArrayList<Route> search_all_route() throws Exception;
	
	public com.geppetto.surveybuilder.domain.core.Route create_route(Route route) throws Exception;
}
