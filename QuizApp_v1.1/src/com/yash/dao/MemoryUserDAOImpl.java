package com.yash.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.yash.entity.User;
import com.yash.repository.UserRepo;

public class MemoryUserDAOImpl implements UserDAO{

	private int userId;
	private List<User> userData = UserRepo.loadUserData();
	@Override
	public boolean checkUserCredentials(String userName, String password) {
		
		for (User user : userData) 
		{
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
//				this.userId=
				return true;
			}
		}
		return false;
	}
	@Override
	public Optional<User> requestUserResponse() 
	{
		User user = userData.stream().filter(x-> x.getUserId() == userId)
				 .collect(Collectors.toList())
				 .get(0);
		Optional<User> optional = Optional.of(user);
		return optional;
	}


}
