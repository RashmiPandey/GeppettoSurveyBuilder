package com.geppetto.surveybuilder.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geppetto.surveybuilder.domain.core.Option;
import com.geppetto.surveybuilder.service.OptionService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * 
 * @author Geppetto Generated Code</br> Date Created: </br>
 * @since </br> build: </p>
 *
 *        code was generated by the Geppetto System </br> Gepppetto system
 *        Copyright - Geppetto LLC 2014 - 2015</br> The generated code is free
 *        to use by anyone</p>
 *
 *
 *
 */

@Api(value = "/Option", description = "Option of Option", produces = "application/json")
@Controller("OptionController")
@RequestMapping("/Option")
public class OptionController extends GpBaseController {

	OptionService Option_service;

	public OptionService get_Option_service() {
		return Option_service;
	}

	@Resource(name = "OptionService")
	public void set_Option_service(OptionService Option_service) {
		this.Option_service = Option_service;
	}

	// auths not ready at this time

	@ApiOperation(value = "/create_Option", httpMethod = "POST", notes = "creates a noun of Option", response = Option.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.POST, value = "/create_Option", headers = "Accept=application/json")
	@ResponseBody
	public Option create_Option(@RequestBody Option the_Option)
			throws Exception {

		Option a_Option;

		a_Option = Option_service.create_option(the_Option, super.getUser());

		return a_Option;

	}

	// auths not ready at this time

	@ApiOperation(value = "/delete_Option/{Option_id}", httpMethod = "DELETE", notes = "deletes a noun of Option", response = Option.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete_Option/{Option_id}", headers = "Accept=application/json")
	@ResponseBody
	public String delete_Option(@PathVariable("Option_id") long Option_id)
			throws Exception {

		String service_return_msg = "";

		service_return_msg = Option_service.delete_option(Option_id,
				super.getUser());

		return service_return_msg;

	}

	// auths not ready at this time

	@ApiOperation(value = "/search_for_update_Option/{Option_id}", httpMethod = "GET", notes = "updates a noun of Option", response = Option.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/search_for_update_Option/{Option_id}", headers = "Accept=application/json")
	@ResponseBody
	public Option search_for_update_Option(
			@PathVariable("Option_id") long Option_id) throws Exception {

		Option the_Option = new Option();

		the_Option = Option_service.option_search_for_update(Option_id);

		return the_Option;

	}

	// auths not ready at this time

	@ApiOperation(value = "/update_Option", httpMethod = "PUT", notes = "updates a noun of Option", response = Option.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.PUT, value = "/update_Option", headers = "Accept=application/json")
	@ResponseBody
	public Option update_Option(@RequestBody Option the_Option)
			throws Exception {

		Option a_Option;

		a_Option = Option_service.update_option(the_Option, super.getUser());

		return a_Option;

	}

	// auths not ready at this time

	@ApiOperation(value = "/search_Option", httpMethod = "GET", notes = "searches a noun of Option", response = Option.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "The request was fulfilled"),
			@ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			@ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			@ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			@ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })
	@RequestMapping(method = RequestMethod.GET, value = "/search_Option", headers = "Accept=application/json")
	@ResponseBody
	public ArrayList<Option> search_Option(
			@RequestParam(required = false, value = "Question_id", defaultValue = "%%") String Question_id,
			@RequestParam(required = false, value = "Answer", defaultValue = "%%") String Answer,
			@RequestParam(required = false, value = "Answer_image", defaultValue = "%%") String Answer_image,
			@RequestParam(required = false, value = "Answer_type", defaultValue = "%%") String Answer_type)
			throws Exception {

		ArrayList<Option> Option_list = new ArrayList<Option>();

		Option_list = Option_service.search_option(Question_id, Answer,
				Answer_image, Answer_type);

		return Option_list;

	}

}