package com.geppetto.surveybuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geppetto.surveybuilder.domain.core.User;
import com.geppetto.surveybuilder.service.SignUpServiceimpl;

@Controller
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private SignUpServiceimpl signUpService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create", headers = "Accept=application/json")
	@ResponseBody
	public User create(@RequestBody User SignUp) throws Exception {
		return signUpService.create(SignUp);
	
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update/", headers = "Accept=application/json")
	@ResponseBody
	public User update(@RequestBody User SignUp) throws Exception {
		return signUpService.update(SignUp);
	}


	/*@RequestMapping(method = RequestMethod.GET, value = "/delete/", headers = "Accept=application/json")
	@ResponseBody
	public void delete(@RequestParam("id") long id) throws Exception {
		// TODO Auto-generated method stub
		signUpService.delete(id);
		
	}*/

	@RequestMapping(method = RequestMethod.GET, value = "/search", headers = "Accept=application/json")
	@ResponseBody
	public User search(@RequestParam("id") long id) throws Exception {
		 return signUpService.search(id);
		
	}
}
