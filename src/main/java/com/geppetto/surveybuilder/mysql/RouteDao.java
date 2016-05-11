package com.geppetto.surveybuilder.mysql;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.geppetto.surveybuilder.domain.core.Route;
import com.geppetto.surveybuilder.interfaces.dao.IRouteDao;

@Transactional
@Repository("RouteDao")
public class RouteDao implements IRouteDao {

	@PersistenceContext
	EntityManager entityManager;

	@Value("${search_all_route.sql}")
	private String search_all_route_sql;

	@Value("${create_route.sql}")
	private String create_route_sql;

	@Override
	public ArrayList<Route> search_all_route() throws Exception {
		// TODO Auto-generated method stub
		try {

			Query result = entityManager.createNativeQuery(search_all_route_sql, Route.class);

			ArrayList<Route> Route_list = (ArrayList<Route>) result.getResultList();

			if (Route_list == null) {
				throw new Exception("null");
			}

			return (ArrayList<Route>) Route_list;

		} catch (Exception e) {

			new Exception(e.toString());

		}
		return null;
	}

	@Override
	public Route create_route(Route route) throws Exception {
		try {

			System.out.println("----" + create_route_sql);

			Query query = entityManager.createNativeQuery(create_route_sql, Route.class)
					.setParameter("location", route.getLocation()).setParameter("route_name", route.getRoute_name());

			query.executeUpdate();
			return route;

		} catch (Exception e) {

			System.out.println("DaoExecetion : " + e.toString());
		}

		return null;
	}

}
