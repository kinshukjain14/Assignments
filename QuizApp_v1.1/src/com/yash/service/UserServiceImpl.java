package com.yash.service;

import java.util.Optional;
import java.util.function.Supplier;

import com.yash.dao.UserDAO;
import com.yash.entity.User;
import com.yash.exception.AuthenticationException;
import com.yash.exception.UserDataNotFoundException;
import com.yash.helper.QuizFactory;
import com.yash.model.UserModel;

public class UserServiceImpl implements UserService {

	private UserDAO dao;
	
	
	public UserServiceImpl() {
		super();
		dao = QuizFactory.newUserDao();
	}

	@Override
	public boolean authenticateUser(String userName, String password) throws AuthenticationException {
		if(dao.checkUserCredentials(userName, password))
			return true;
		else
			throw new AuthenticationException("== Invalid username or password ==");
	}

	@Override
	public UserModel sendUserData() throws UserDataNotFoundException {
		Optional<User> requestUserResponse = dao.requestUserResponse();
		UserModel model = new UserModel();
		if(requestUserResponse.isPresent()) {
			String message="Data Requested not found";
			Supplier<UserDataNotFoundException> exceptionSupplier = () -> new UserDataNotFoundException(message);
			User reqUser = requestUserResponse.orElseThrow(exceptionSupplier);

			model.setName(reqUser.getName());
			model.setContactNo(reqUser.getContactNo());
			model.setEmail(reqUser.getEmail());
		}
		
		return model;
	}
	
	

}
