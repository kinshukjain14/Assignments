package com.yash.repository;

import java.util.ArrayList;
import java.util.List;

import com.yash.entity.User;

public class UserRepo 
{
	public static List<User> loadUserData() {
		List<User> userList = new ArrayList<User>();
		userList.add(new User(101,"kinshuk.jain14","kinshu123","Kinshuk Jain","kinshuk.jain@yash.com",8619584428L));
		userList.add(new User(102,"admin","admin123","Administrator","admin@yash.com",8619584428L));
		userList.add(new User(103,"ashutosh12","12345","Ashutosh Pathak","ashutosh.pathak@yash.com",8619584428L));
		userList.add(new User(104,"aishwary13","12345","Aishwary Nashikkar","aishwary.nashikkar@yash.com",8619584428L));
		userList.add(new User(105,"lokesh14","12345","Malladi Lokesh Babu","lokesh.babu@yash.com",8619584428L));
		userList.add(new User(106,"venkata15","12345","Gorre Venkata Harikrishna","venkata.gorre@yash.com",8619584428L));
		
		return userList;
	}
}
