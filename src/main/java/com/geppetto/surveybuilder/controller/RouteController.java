package com.geppetto.surveybuilder.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geppetto.surveybuilder.domain.core.Route;
import com.geppetto.surveybuilder.domain.core.Store;
import com.geppetto.surveybuilder.service.RouteServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Api(value = "/Route", description = "route of Route", produces = "application/json")

@Controller("RouteController")
@RequestMapping("/Route")
public class RouteController {

	RouteServiceImpl routeServiceImpl;

	public RouteServiceImpl getRouteServiceImpl() {
		return routeServiceImpl;
	}

	@Resource(name = "RouteServiceImpl")
	public void setRouteServiceImpl(RouteServiceImpl routeServiceImpl) {
		this.routeServiceImpl = routeServiceImpl;
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "/get_all_route_for_desktop", httpMethod = "GET", notes = "special search that gets all values of Route", response = Route.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_all_route_for_desktop", headers = "Accept=application/json")
	@ResponseBody
	public ArrayList<Route> get_all_Route_for_desktop() throws Exception {

		ArrayList<Route> Route_list = new ArrayList<Route>();

		Route_list = routeServiceImpl.search_all_route();

		return Route_list;

	}

	@ApiOperation(value = "/create_route", httpMethod = "POST", notes = "creates a route of Route", response = Route.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/create_route", headers = "Accept=application/json")
	@ResponseBody
	public Route create_route(@RequestBody Route Route) throws Exception {

		Route a_Route;

		a_Route = routeServiceImpl.create_route(Route);

		return a_Route;

	}

}
