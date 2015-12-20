package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.User;
import com.projetidoine.service.CryptWithMD5;
import com.projetidoine.service.UserService;

public class UserAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private User user;
	private Long idUser;
	private UserService userService;
	
	public void prepare() throws Exception {
		this.user = null;
		this.idUser = null;
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
	
	public String displayRegister(){
		return SUCCESS;
	}
	
	public String displayLogin(){
		return SUCCESS;
	}
	
	public String saveUser() {
		System.out.println("dans saveUser");
		user.setPassword(CryptWithMD5.cryptWithMD5(user.getPassword()));
		userService.addUser(user);
		return SUCCESS;
	}
}
