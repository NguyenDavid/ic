package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.User;

public class UserAction extends ActionSupport implements Preparable {
	private User user;
	
	public void prepare() throws Exception {
	}

	public String displayLogin(){
		System.out.println("Dans displayLogin");
		return SUCCESS;
	}
}
