package com.pennant.cms.dao;

import com.pennant.cms.models.User;

public interface CMSUserDao {

	public void addUser(User user);

	boolean isExisting(String username);

	User getUser(String username , String password);
	
}
