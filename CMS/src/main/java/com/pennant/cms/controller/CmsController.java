package com.pennant.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pennant.cms.dao.impl.CMSUserDaoImpl;
import com.pennant.cms.models.User;

@RestController
public class CmsController {

	private CMSUserDaoImpl cMSUserDaoImpl;
	
	@Autowired
	public CmsController(CMSUserDaoImpl cMSUserDaoImpl) {
		this.cMSUserDaoImpl=cMSUserDaoImpl;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public User admin(@RequestBody User user) {
		
		User user1 = cMSUserDaoImpl.getUser(user.getUsername(),user.getPassword());
		
		System.out.println(user1.getName());
		
		return user1;
	}
	
}
