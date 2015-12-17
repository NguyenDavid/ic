package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class FirstAction extends ActionSupport implements Preparable {
	
	public void prepare() throws Exception {
	}

	public String home(){
		System.out.println("Dans home");
		return SUCCESS;
	}
}
