package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;
import com.projetidoine.service.EventService;
import com.projetidoine.service.UserService;

public class EventAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Event event;
	private Long idEvent;
	private EventService eventService;
	private UserService userService;
	private List<Event> listEvents = new ArrayList<Event>();
	private List<User> listUsers = new ArrayList<User>();
	
	public void prepare() throws Exception {
		this.event = null;
		this.idEvent = null;
	}
	
	public String languageEvent(){
		return SUCCESS;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	public String saveEvent(){
		System.out.println("saveEvent");
		System.out.println("desc : "+event.getDescription());
		System.out.println("nbPlayers : "+event.getNbPlayers());
		System.out.println("nbMaxPlayers : "+event.getNbMaxPlayers());
		System.out.println("date : "+event.getDate());
		System.out.println("game : "+event.getGame().getName());
		System.out.println("lieu : "+event.getLocation().getName());
		if(event.getDescription().equals(""))
			event.setDescription("-");
		System.out.println(event.getDescription());
		eventService.addEvent(event);
		System.out.println("fin saveEvent");
		return SUCCESS;
	}
	
	public List<Event> getListEvents(){
		return this.listEvents;
	}
	
	public void setListEvents(List<Event> listEvents){
		this.listEvents = listEvents;
	}
	
	public String listEvents(){
		listEvents = eventService.getAllEvents();
		listUsers = userService.getAllUsers();
		return SUCCESS;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> getListUsers(){
		return this.listUsers;
	}
	
	public void setListUsers(List<User> listUsers){
		this.listUsers = listUsers;
	}
}
