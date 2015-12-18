package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.User;
import com.projetidoine.service.UserService;

public class UserAction extends ActionSupport implements Preparable {
//	private List<User> listUsers=new ArrayList<User>();
	private User user;
	private Long idUser;
	private UserService userService;
	
	public void prepare() throws Exception {
		this.user = null;
		this.idUser = null;
	}

	public String displayLogin(){
		System.out.println("Dans displayLogin");
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
