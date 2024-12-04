package com.demo.service;

import com.demo.dao.DaoOperations;
import com.demo.dao.DaoOperationsImpl;

public class LoginImpl implements Login{
DaoOperations dao=new DaoOperationsImpl();

	public boolean getUser(String username, String password) {
		return dao.getuser(username,password);
	}

}
