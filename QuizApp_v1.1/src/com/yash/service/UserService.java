package com.yash.service;

import com.yash.exception.AuthenticationException;
import com.yash.exception.UserDataNotFoundException;
import com.yash.model.UserModel;

public interface UserService {
	public boolean authenticateUser(String userName,String password) throws AuthenticationException;
	public UserModel sendUserData() throws UserDataNotFoundException;
}
