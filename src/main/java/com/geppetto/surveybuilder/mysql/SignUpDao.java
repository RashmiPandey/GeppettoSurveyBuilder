package com.geppetto.surveybuilder.mysql;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geppetto.surveybuilder.domain.core.User;
import com.geppetto.surveybuilder.interfaces.dao.ISignUpDao;

@Repository
@Transactional
public class SignUpDao implements ISignUpDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public User create(User SignUp) throws Exception {
		entityManager.persist(SignUp);
		entityManager.flush();
		return SignUp;
	}
	
	@Override
	@Transactional
	public User update(User SignUp) throws Exception {
		entityManager.merge(SignUp);
		entityManager.flush();
		return SignUp;
	}

	@Override
	public User search(long id) throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		User signUp;
		signUp = (User) entityManager.find(User.class, id);
		return signUp;
	}
}
