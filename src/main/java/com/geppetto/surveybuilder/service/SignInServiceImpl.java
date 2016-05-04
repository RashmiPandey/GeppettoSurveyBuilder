package com.geppetto.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geppetto.surveybuilder.domain.core.CareGiver;
import com.geppetto.surveybuilder.domain.core.Customer;
import com.geppetto.surveybuilder.domain.core.KeyValueData;
import com.geppetto.surveybuilder.domain.core.User;
import com.geppetto.surveybuilder.interfaces.service.SignInService;
import com.geppetto.surveybuilder.mysql.SignInDao;
import com.geppetto.surveybuilder.mysql.SignUpDao;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {

	@Autowired
	private SignInDao signInDao;

	@Autowired
	private SignUpDao signUpDao;

	@Override
	public Object isValidLogin(User user) throws Exception {
		List<User> userObj = signInDao.isValidLogin(user);
		System.out.println("first-----" + userObj.toString());
		Object object = null;
		if (userObj.size() > 0) {
			System.out.println("login successfull");
			User useObji = userObj.get(0);
			System.out.println("object in list---" + useObji.toString());
			useObji.setLoggedIn(true);
			User Obj = signUpDao.update(useObji);
			if (Obj.getUserType().name() == "CUSTOMER") {
				List<Customer> customer = signInDao.getCustomer(Obj.getId());
				object = customer;
			} else {
				List<CareGiver> care = signInDao.getCareGiver(Obj.getId());
				object = care;
			}
		} else {
			System.out.println("login failed");
			object = "failed";
		}
		return object;
	}

	@Override
	public List<KeyValueData> isEnvironment(KeyValueData key) {
		List<KeyValueData> values = signInDao.isEnviron(key);
		List<KeyValueData> keyValue = null;
		System.out.println("values.size()===="+values.size()); 
		if (values.size() >=0) {
			System.out.println("Already logged successfull");
			KeyValueData useObji = values.get(0);
			System.out.println("Cheking Values  " + useObji.getKey1());
			System.out.println("Cheking Values  " + useObji.getValue1());
			keyValue = values;
			return keyValue;
		}
		return keyValue;
	}

}