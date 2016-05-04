package com.geppetto.surveybuilder.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geppetto.surveybuilder.domain.core.User;
import com.geppetto.surveybuilder.interfaces.service.SignUpService;
import com.geppetto.surveybuilder.mysql.SignUpDao;

@Service
@Transactional
public class SignUpServiceimpl implements SignUpService {
	
	@Autowired
	private SignUpDao signUpDao;

	@Override
	public User update(User SignUp) throws Exception {
		return signUpDao.update(SignUp);
		
	}

	/*@Override
	public void delete(long id) throws Exception {
		// TODO Auto-generated method stub
		signUpDao.delete(id);
		
	}*/

	@Override
	public User search(long id) throws Exception {
		return signUpDao.search(id);
	
	}

	@Override
	public User create(User SignUp) throws Exception {
		return 	signUpDao.create(SignUp);
	}

}
