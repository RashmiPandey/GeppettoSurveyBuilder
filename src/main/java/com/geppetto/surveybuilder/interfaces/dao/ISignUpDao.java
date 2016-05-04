package com.geppetto.surveybuilder.interfaces.dao;

import com.geppetto.surveybuilder.domain.core.User;

public interface ISignUpDao {

	User create(User SignUp) throws Exception;

	User update(User SignUp) throws Exception;

	User search(long id) throws Exception;

}
