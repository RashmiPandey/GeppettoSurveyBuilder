package com.geppetto.surveybuilder.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.geppetto.surveybuilder.domain.core.Client;
import com.geppetto.surveybuilder.service.Client_Default_ActivityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
   build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC 2014 - 2015</br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/

@Api(value = "/Client_Default_Activity", description = "Client_Default_Activity of Client_Default_Activity", 
produces = "application/json")

@Controller("Client_Default_ActivityController")
@RequestMapping("/Client_Default_Activity")
public class Client_Default_ActivityController extends GpBaseController {


	Client_Default_ActivityService Client_Default_Activity_service;


	public Client_Default_ActivityService get_Client_Default_Activity_service() {
		return Client_Default_Activity_service;
	}


	@Resource(name="Client_Default_ActivityService")
	public void set_Client_Default_Activity_service(Client_Default_ActivityService Client_Default_Activity_service) {
		this.Client_Default_Activity_service = Client_Default_Activity_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/create_Client", httpMethod = "POST",
	notes = "creates a noun of Client", 
	response = Client.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/create_Client", headers="Accept=application/json")
    @ResponseBody
	public Client create_Client(@RequestBody Client the_Client) throws Exception {

		Client a_Client;

		a_Client = Client_Default_Activity_service.create_client(the_Client, super.getUser());

		return a_Client;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_Client/{Client_id}", httpMethod = "GET",
	notes = "updates a noun of Client", 
	response = Client.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/search_for_update_Client/{Client_id}", headers="Accept=application/json")
    @ResponseBody
	public Client search_for_update_Client(@PathVariable("Client_id")long Client_id) throws Exception {

		Client the_Client = new Client();

		the_Client = Client_Default_Activity_service.client_search_for_update(Client_id, super.getUser());

		return the_Client;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_Client", httpMethod = "PUT",
	notes = "updates a noun of Client", 
	response = Client.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT, value = "/update_Client", headers="Accept=application/json")
    @ResponseBody
	public Client update_Client(@RequestBody Client the_Client) throws Exception {

		Client a_Client;

		a_Client = Client_Default_Activity_service.update_client(the_Client, super.getUser());

		return a_Client;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Client/{Client_id}", httpMethod = "DELETE",
	notes = "deletes a noun of Client", 
	response = Client.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete_Client/{Client_id}", headers="Accept=application/json")
    @ResponseBody
	public String  delete_Client(@PathVariable("Client_id")long Client_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Client_Default_Activity_service.delete_client(Client_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_all_Client", httpMethod = "GET",
	notes = "special search that gets all values of Client", 
	response = Client.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/get_all_Client", headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Client> get_all_Client() throws Exception {

		ArrayList<Client> Client_list = new ArrayList<Client>();

		Client_list = Client_Default_Activity_service.get_all_client();

		return Client_list;

	}




}