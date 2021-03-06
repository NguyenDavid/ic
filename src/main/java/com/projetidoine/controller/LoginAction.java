package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;
import com.projetidoine.entity.Location;
import com.projetidoine.entity.User;
import com.projetidoine.service.CryptWithMD5;
import com.projetidoine.service.EventService;
import com.projetidoine.service.GameService;
import com.projetidoine.service.LocationService;
import com.projetidoine.service.UserService;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private Map<String, Object> sessionAttributes = null;
	private UserService userService;
	private GameService gameService;
	private LocationService locationService;
	private List<Game> listGames = new ArrayList<Game>();
	private List<Location> listLocations = new ArrayList<Location>();
	private List<User> listUsers = new ArrayList<User>();
	private List<Event> listEvents = new ArrayList<Event>();
	private EventService eventService;

	public String home(){
		sessionAttributes = ActionContext.getContext().getSession();
		user = (User) sessionAttributes.get("user");
		listGames = gameService.getAllGames();
		listLocations = locationService.getAllLocations();
		listUsers = userService.getAllUsers();
		listEvents = eventService.getEventByIdUser(user.getIdUser());
		return SUCCESS;
	}
	
	public String languageRegister(){
		return SUCCESS;
	}
	
	public String languageLogin(){
		return SUCCESS;
	}
	
	//connexion
	@Override
	public String execute() {
		System.out.println("A l'interieur de l'action LoginAction");
		User a = userService.getUserByLogin(user.getLogin());
		if (a != null) {
			if (a.getPassword().equals(
					CryptWithMD5.cryptWithMD5(user.getPassword()))) {
				user.setIdUser(a.getIdUser());
				user.setEmail(a.getEmail());
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
	
	//deconnexion
	public String deleteSession(){
		sessionAttributes = ActionContext.getContext().getSession();
		sessionAttributes.remove("user");
		sessionAttributes.clear();
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
	
	public void setGameService(GameService gameService){
		this.gameService = gameService;
	}
	
	public List<Game> getListGames(){
		return this.listGames;
	}
	
	public void setListGames(List<Game> listGames){
		this.listGames = listGames;
	}
	
	public String listGames(){
		listGames = gameService.getAllGames();
		return SUCCESS;
	}
	
	public void setLocationService(LocationService locationService){
		this.locationService = locationService;
	}
	
	public List<Location> getListLocations(){
		return this.listLocations;
	}
	
	public void setListLocations(List<Location> listLocations){
		this.listLocations = listLocations;
	}
	
	public List<User> getListUsers(){
		return this.listUsers;
	}
	
	public void setListUsers(List<User> listUsers){
		this.listUsers = listUsers;
	}
	
	public void setEventService(EventService eventService){
		this.eventService = eventService;
	}

	public List<Event> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Event> listEvents) {
		this.listEvents = listEvents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
