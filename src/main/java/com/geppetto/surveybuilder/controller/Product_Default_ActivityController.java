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

import com.geppetto.surveybuilder.domain.core.Product;
import com.geppetto.surveybuilder.service.Product_Default_ActivityService;
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

@Api(value = "/Product_Default_Activity", description = "Product_Default_Activity of Product_Default_Activity", 
produces = "application/json")

@Controller("Product_Default_ActivityController")
@RequestMapping("/Product_Default_Activity")
public class Product_Default_ActivityController extends GpBaseController {


	Product_Default_ActivityService Product_Default_Activity_service;


	public Product_Default_ActivityService get_Product_Default_Activity_service() {
		return Product_Default_Activity_service;
	}


	@Resource(name="Product_Default_ActivityService")
	public void set_Product_Default_Activity_service(Product_Default_ActivityService Product_Default_Activity_service) {
		this.Product_Default_Activity_service = Product_Default_Activity_service;
	}




	//auths not ready at this time


	@ApiOperation(value = "/create_Product", httpMethod = "POST",
	notes = "creates a noun of Product", 
	response = Product.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.POST, value = "/create_Product", headers="Accept=application/json")
    @ResponseBody
	public Product create_Product(@RequestBody Product the_Product) throws Exception {

		Product a_Product;

		a_Product = Product_Default_Activity_service.create_product(the_Product, super.getUser());

		return a_Product;

	}

	//auths not ready at this time


	@ApiOperation(value = "/search_for_update_Product/{Product_id}", httpMethod = "GET",
	notes = "updates a noun of Product", 
	response = Product.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/search_for_update_Product/{Product_id}", headers="Accept=application/json")
    @ResponseBody
	public Product search_for_update_Product(@PathVariable("Product_id")long Product_id) throws Exception {

		Product the_Product = new Product();

		the_Product = Product_Default_Activity_service.product_search_for_update(Product_id, super.getUser());

		return the_Product;

	}

	//auths not ready at this time


	@ApiOperation(value = "/update_Product", httpMethod = "PUT",
	notes = "updates a noun of Product", 
	response = Product.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.PUT, value = "/update_Product", headers="Accept=application/json")
    @ResponseBody
	public Product update_Product(@RequestBody Product the_Product) throws Exception {

		Product a_Product;

		a_Product = Product_Default_Activity_service.update_product(the_Product, super.getUser());

		return a_Product;

	}

	//auths not ready at this time


	@ApiOperation(value = "/delete_Product/{Product_id}", httpMethod = "DELETE",
	notes = "deletes a noun of Product", 
	response = Product.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete_Product/{Product_id}", headers="Accept=application/json")
    @ResponseBody
	public String  delete_Product(@PathVariable("Product_id")long Product_id) throws Exception {

		String service_return_msg = "";

		service_return_msg = Product_Default_Activity_service.delete_product(Product_id, super.getUser());

		return service_return_msg;

	}

	//auths not ready at this time


	@ApiOperation(value = "/get_all_Product", httpMethod = "GET",
	notes = "special search that gets all values of Product", 
	response = Product.class)
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was fulfilled"),
	    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
	    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
	    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
	    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

	@RequestMapping(method = RequestMethod.GET, value = "/get_all_Product", headers="Accept=application/json")
    @ResponseBody
	public ArrayList<Product> get_all_Product() throws Exception {

		ArrayList<Product> Product_list = new ArrayList<Product>();

		Product_list = Product_Default_Activity_service.get_all_product();

		return Product_list;

	}
	
	@ApiOperation(value = "/get_product_by_client_id/{client_id}", httpMethod = "GET",
			notes = "special search that gets all values of Product", 
			response = Product.class)
		    @ApiResponses(value = { 
		        @ApiResponse(code = 200, message = "The request was fulfilled"),
			    @ApiResponse(code = 404, message = "The server has not found anything matching the URI given"),
			    @ApiResponse(code = 500, message = "Internal server error due to encoding the data"),
			    @ApiResponse(code = 400, message = "Bad request due to decoding the data"),
			    @ApiResponse(code = 412, message = "Pre condition failed due to required data not found") })

			@RequestMapping(method = RequestMethod.GET, value = "/get_product_by_client_id/{client_id}", headers="Accept=application/json")
		    @ResponseBody
			public ArrayList<Product> get_product_by_client_id(@PathVariable("client_id")long client_id) throws Exception {

				ArrayList<Product> Product_list = new ArrayList<Product>();

				Product_list = Product_Default_Activity_service.get_product_by_client_id(client_id);

				return Product_list;

			}




}