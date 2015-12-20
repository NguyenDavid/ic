package com.projetidoine.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projetidoine.entity.User;
import com.projetidoine.service.CryptWithMD5;
import com.projetidoine.service.UserService;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private Map<String, Object> sessionAttributes = null;
	private UserService userService;

	public String home(){
		System.out.println("Dans home");
		return SUCCESS;
	}
	
	@Override
	public String execute() {
		System.out.println("A l'interieur de l'action LoginAction");
		User a = userService.getUserByLogin(user.getLogin());
		if (a != null) {
			if (a.getPassword().equals(
					CryptWithMD5.cryptWithMD5(user.getPassword()))) {
				sessionAttributes.put("user", user);
				return SUCCESS;
			} else {
				// addActionError("Erreur d'authentification : Mot de passe errone'");
				user = new User();
				sessionAttributes.remove(user);
				return ERROR;
			}
		}
		// addActionError("Erreur d'authentification : Login errone'");
		user = new User();
		sessionAttributes.remove(user);
		return ERROR;

	}
	
	public String deleteSession(){
		sessionAttributes = ActionContext.getContext().getSession();
		sessionAttributes.remove("user");
		sessionAttributes.clear();
		System.out.println("Login Action fin deleteSession");
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService(){
		return this.userService;
	}	
}
