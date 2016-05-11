package com.geppetto.surveybuilder.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.geppetto.surveybuilder.domain.core.Route;
import com.geppetto.surveybuilder.domain.core.Store;
import com.geppetto.surveybuilder.interfaces.service.RouteService;
import com.geppetto.surveybuilder.mysql.RouteDao;

@Service("RouteServiceImpl")
public class RouteServiceImpl  implements RouteService{
	
	RouteDao routeDao;

	public RouteDao getRouteDao() {
		return routeDao;
	}

	@Resource(name = "RouteDao")
	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	@Override
	public ArrayList<Route> search_all_route() throws Exception {
		try {
			ArrayList<Route> Route_list;

			Route_list = routeDao.search_all_route();

			return Route_list;

		} catch (Exception e) {

			System.out.println("ServiceException: " + e.toString());

		}
		return null;

	}

	public com.geppetto.surveybuilder.domain.core.Route create_route(Route route) {
		try{
			Route routeName;

			routeName = routeDao.create_route(route);

			return routeName;			

		}catch(Exception e){

			System.out.println("ServiceException: " + e.toString());

		}
		return null;
	}

}
