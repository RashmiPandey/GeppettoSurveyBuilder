package com.geppetto.surveybuilder.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geppetto.surveybuilder.domain.core.Product;
import com.geppetto.surveybuilder.domain.core.Question;
import com.geppetto.surveybuilder.domain.core.Route;
import com.geppetto.surveybuilder.domain.core.Store;
import com.geppetto.surveybuilder.service.StoreServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;


@Api(value = "/Store", description = "store of Store", 
produces = "application/json")

@Controller("StoreController")
@RequestMapping("/Store")
public class StoreController {

	StoreServiceImpl storeServiceImpl;

	public StoreServiceImpl getStoreServiceImpl() {
		return storeServiceImpl;
	}

	@Resource(name = "StoreServiceImpl")
	public void setStoreServiceImpl(StoreServiceImpl storeServiceImpl) {
		this.storeServiceImpl = storeServiceImpl;
	}

	@CrossOrigin(origins = "*")
	@ApiOperation(value = "/get_all_store_for_desktop", httpMethod = "GET", notes = "special search that gets all values of Store", response = Store.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/get_all_store_for_desktop", headers = "Accept=application/json")
	@ResponseBody
	public ArrayList<Store> get_all_Store_for_desktop() throws Exception {

		ArrayList<Store> Store_list = new ArrayList<Store>();

		Store_list = storeServiceImpl.search_all_store();

		return Store_list;

	}
	
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "/get_all_store_by_route_id/{route_id}", httpMethod = "GET",
	notes = "get_all_store_by_route_id", 
	response = Question.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/get_all_store_by_route_id/{route_id}", headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Store> get_all_store_by_route_id(@PathVariable("route_id")long route_id) throws Exception {

		ArrayList<Store> Store_list = new ArrayList<Store>();

		Store_list = storeServiceImpl.get_all_store_by_route_id(route_id);

		return Store_list;

	}

	@ApiOperation(value = "/create_store", httpMethod = "POST",
	notes = "creates a store of Stores", 
	response = Store.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/create_store", headers="Accept=application/json")
    @ResponseBody
	public Store create_Store(@RequestBody Store the_Store) throws Exception {

		Store a_Store;

		a_Store = storeServiceImpl.create_Store(the_Store);

		return a_Store;
	}
		
	

	@ApiOperation(value = "/update_store", httpMethod = "POST",
	notes = "creates a store of Stores", 
	response = Store.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/update_store", headers="Accept=application/json")
    @ResponseBody
	public Store update_Store(@RequestBody Store the_Store) throws Exception {
		Store a_Store;
		a_Store = storeServiceImpl.update_Store(the_Store);
		return a_Store;
	}
	

	@ApiOperation(value = "/delete_store", httpMethod = "POST",
	notes = "creates a store of Stores", 
	response = Store.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/delete_store", headers="Accept=application/json")
    @ResponseBody
	public void delete_Store(@RequestBody Store the_Store) throws Exception {

		  storeServiceImpl.delete_store(the_Store);
	}
	
}
