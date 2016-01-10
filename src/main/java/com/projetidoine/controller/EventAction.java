package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
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
import com.projetidoine.service.GameService;
import com.projetidoine.service.LocationService;
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
	private List<Game> games = new ArrayList<Game>();
	private List<Location> locations = new ArrayList<Location>();
	private Long idLocation;
	private Long idGame;
	private GameService gameService;
	private LocationService locationService;
	
	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public Long getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

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
		this.idGame = null;
		this.idLocation = null;
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
		
		@SuppressWarnings("deprecation")
		Date d = new Date(year, month, day);
		event.setDate(d);
		System.out.println(d.toString());
		System.out.println("saveEvent");
		System.out.println("desc : "+event.getDescription());
		System.out.println("nbPlayers : "+event.getNbPlayers());
		System.out.println("nbMaxPlayers : "+event.getNbMaxPlayers());
		System.out.println("date : "+event.getDate());
		System.out.println("game : "+idGame);
		System.out.println("lieu : "+idLocation);
		System.out.println(event.getDescription());
		
		if(event.getDescription().equals(""))
			event.setDescription("-");
		
		Game game = gameService.getGameById(idGame);
		Location location = locationService.getLocationById(idLocation);
		event.setGame(game);
		event.setLocation(location);
		
		System.out.println(event.getGame().getName());
		System.out.println(event.getLocation().getName());
		
		//ajout du createur
		sessionAttributes = ActionContext.getContext().getSession();
		user = (User) sessionAttributes.get("user");
//		List<User> users = new ArrayList<User>();
//		users.add(user);
//		event.setUsers(users);
		
		
		event.setUsers(new HashSet<User>());
		event.getUsers().add(user);
		event.setNbPlayers(event.getUsers().size());
//		event.setUsers(new ArrayList<User>());
//		event.getUsers().add(user);
//		user.set
		
//		System.out.println(event.getUsers().size());
		
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
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}
}
