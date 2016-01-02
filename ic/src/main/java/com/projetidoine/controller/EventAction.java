package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;
import com.projetidoine.entity.Location;
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
	private int year;
	private int month;
	private int day;
	private Game game;
	private Location location;
	private User user = new User();
	private Map<String, Object> sessionAttributes = null;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void prepare() throws Exception {
		this.event = null;
		this.idEvent = null;
		this.game = null;
		this.location = null;
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
		System.out.println("debut saveEvent");
		if(event.getGame() == null)
			System.out.println("jeu null");
		if(event.getLocation() == null)
			System.out.println("lieu null");
		@SuppressWarnings("deprecation")
		Date d = new Date(year, month, day);
		event.setDate(d);
		System.out.println(d.toString());
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
		
		//ajout du createur
		sessionAttributes = ActionContext.getContext().getSession();
		user = (User) sessionAttributes.get("user");
		List<User> users = new ArrayList<User>();
		users.add(user);
		event.setUsers(users);
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
		Collections.sort(listEvents, new Comparator<Event>() {
		    public int compare(Event e1, Event e2) {		    	
		        return e1.getDate().compareTo(e2.getDate());
		    }
		});
		sessionAttributes = ActionContext.getContext().getSession();
		user = (User) sessionAttributes.get("user");
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
	
	public String updatePlayers(){
		eventService.addPlayerInEvent(user, idEvent);
		System.out.println("eventAction fin");
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
}
