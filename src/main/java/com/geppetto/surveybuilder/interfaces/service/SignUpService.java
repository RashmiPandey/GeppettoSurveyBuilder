package com.geppetto.surveybuilder.interfaces.service;

import com.geppetto.surveybuilder.domain.core.User;

public interface SignUpService {
	
	public User create(User SignUp) throws Exception;
	public User update(User SignUp) throws Exception;
	//public void delete(long id) throws Exception;
	public User search (long id) throws Exception;
	

}
