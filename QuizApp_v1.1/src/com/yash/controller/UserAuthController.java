package com.yash.controller;

import com.yash.exception.AuthenticationException;
import com.yash.exception.UserDataNotFoundException;
import com.yash.helper.QuizFactory;
import com.yash.model.UserModel;
import com.yash.service.UserService;

public class UserAuthController {
	
	UserService service;
	public UserAuthController() {
		super();
		service = QuizFactory.newUserAuthService();
	}

	public boolean handleUserAuth(UserModel user) throws AuthenticationException
	{
		String userName=user.getUserName();
		String password = user.getPassword();
		return service.authenticateUser(userName, password);
	}
	
	public UserModel handleUserDetailsRequest() throws UserDataNotFoundException {
		return service.sendUserData();
	}
}
