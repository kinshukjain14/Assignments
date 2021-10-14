package com.yash.dao;

import java.util.Optional;

import com.yash.entity.User;

public interface UserDAO {
	public boolean checkUserCredentials(String userName, String password);
	public Optional<User> requestUserResponse();
}
