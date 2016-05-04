package com.geppetto.surveybuilder.interfaces.service;


import java.util.List;

import com.geppetto.surveybuilder.domain.core.KeyValueData;
import com.geppetto.surveybuilder.domain.core.User;

public interface SignInService {
	
	
	public Object isValidLogin(User user) throws Exception;
	public List<KeyValueData> isEnvironment(KeyValueData user);
	
	
}
