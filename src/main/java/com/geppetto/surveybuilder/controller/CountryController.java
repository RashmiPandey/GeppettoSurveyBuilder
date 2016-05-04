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

import com.geppetto.surveybuilder.domain.core.Country;
import com.geppetto.surveybuilder.service.CountryService;
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

@Api(value = "/Country", description = "country of Country", 
produces = "application/json")

@Controller("CountryController")
@RequestMapping("/Country")
public class CountryController extends GpBaseController {


	CountryService Country_service;


	public CountryService get_Country_service() {
		return Country_service;
	}


	@Resource(name="CountryService")
	public void set_Country_service(CountryService Country_service) {
		this.Country_service = Country_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_Country/{Country_id}", httpMethod = "GET",
	notes = "updates a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/search_for_update_Country/{Country_id}", headers="Accept=application/json")
    @ResponseBody
	public Country search_for_update_Country(@PathVariable("Country_id")long Country_id) throws Exception {

		Country the_Country = new Country();

		the_Country = Country_service.country_search_for_update(Country_id, super.getUser());

		return the_Country;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_Country", httpMethod = "PUT",
	notes = "updates a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT, value = "/update_Country", headers="Accept=application/json")
    @ResponseBody
	public Country update_Country(@RequestBody Country the_Country) throws Exception {

		Country a_Country;

		a_Country = Country_service.update_country(the_Country, super.getUser());

		return a_Country;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Country/{Country_id}", httpMethod = "DELETE",
	notes = "deletes a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete_Country/{Country_id}", headers="Accept=application/json")
    @ResponseBody
	public String  delete_Country(@PathVariable("Country_id")long Country_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Country_service.delete_country(Country_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/create_Country", httpMethod = "POST",
	notes = "creates a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/create_Country", headers="Accept=application/json")
    @ResponseBody
	public Country create_Country(@RequestBody Country the_Country) throws Exception {
		Country e = new Country();
		e.setCapital("sdfh");
		e.setCommon_name("jhdjfh");
		e.setCurrency_name("sfsdf");
		e.setFormal_name("dgfdg");
		e.setIso_three_letter_code("dsfdf");
		e.setTelephone_code("sdfdf");
		
		System.out.println("country object  : " + the_Country.toString());
		Country a_Country;

		a_Country = Country_service.create_country(the_Country, super.getUser());

		return a_Country;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_Country", httpMethod = "GET",
	notes = "searches a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/search_Country", headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Country> search_Country(@RequestParam(required = false, value = "Common_name", defaultValue = "%%") String Common_name,@RequestParam(required = false, value = "Formal_name", defaultValue = "%%") String Formal_name,@RequestParam(required = false, value = "Iso_three_letter_code", defaultValue = "%%") String Iso_three_letter_code,@RequestParam(required = false, value = "Capital", defaultValue = "%%") String Capital,@RequestParam(required = false, value = "Currency_name", defaultValue = "%%") String Currency_name,@RequestParam(required = false, value = "Telephone_code", defaultValue = "%%") String Telephone_code) throws Exception {

		ArrayList<Country> Country_list = new ArrayList<Country>();

		Country_list = Country_service.search_country(Common_name,Formal_name,Iso_three_letter_code,Capital,Currency_name,Telephone_code);

		return Country_list;

	}


	@ApiOperation(value = "/search_all_Country", httpMethod = "GET",
	notes = "searches a noun of Country", 
	response = Country.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/search_all_Country", headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Country> search_all_Country() throws Exception {

		ArrayList<Country> Country_list = new ArrayList<Country>();

		Country_list = Country_service.search_all_country();

		return Country_list;

	}


}