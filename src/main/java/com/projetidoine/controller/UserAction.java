package com.projetidoine.controller;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
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
	private Map<String, Object> sessionAttributes = null;
	
	public void prepare() throws Exception {
		this.user = null;
		this.idUser = null;
	}
	
	public String languageHome(){
		return SUCCESS;
	}
	
	public String execute() throws Exception {
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
	
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	public String displayRegister(){
		return SUCCESS;
	}
	
	public String displayLogin(){
		return SUCCESS;
	}
	
	public String saveUser() {
		user.setPassword(CryptWithMD5.cryptWithMD5(user.getPassword()));
		userService.addUser(user);
		sessionAttributes = ActionContext.getContext().getSession();
		sessionAttributes.put("user", user);
		return SUCCESS;
	}
}
