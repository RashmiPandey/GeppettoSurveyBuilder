package com.geppetto.surveybuilder.interfaces.dao;

import java.util.List;

import com.geppetto.surveybuilder.domain.core.CareGiver;
import com.geppetto.surveybuilder.domain.core.Customer;
import com.geppetto.surveybuilder.domain.core.KeyValueData;
import com.geppetto.surveybuilder.domain.core.User;

public interface ISignInDao {

	List<KeyValueData> isEnviron(KeyValueData keyVal);

	List<CareGiver> getCareGiver(Long id) throws Exception;

	List<Customer> getCustomer(Long id) throws Exception;

	List<User> isValidLogin(User user) throws Exception;

	User loginValidation(User user);

}
