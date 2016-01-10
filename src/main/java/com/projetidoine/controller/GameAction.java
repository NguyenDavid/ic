package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Game;
import com.projetidoine.entity.User;
import com.projetidoine.service.GameService;
import com.projetidoine.service.UserService;

public class GameAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Game game;
	private Long idGame;
	private UserService userService;
	private GameService gameService;
	private List<Game> listGames = new ArrayList<Game>();
	private List<User> listUsers = new ArrayList<User>();
	private Map<String, Object> sessionAttributes = null;
	private User user = new User();
	
	public void prepare() throws Exception {
		this.game = null;
		this.idGame = null;
	}
	
	public String languageGame(){
		return SUCCESS;
	}
	
	public String saveGame(){
		gameService.addGame(game);
		return SUCCESS;
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public Long getIdGame(){
		return idGame;
	}
	
	public void setIdGame(Long idGame){
		this.idGame = idGame;
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
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> getListUsers(){
		return this.listUsers;
	}
	
	public void setListUsers(List<User> listUsers){
		this.listUsers = listUsers;
	}
	
	public String listGames(){
		sessionAttributes = ActionContext.getContext().getSession();
		user = (User) sessionAttributes.get("user");
		listUsers = userService.getAllUsers();
		listGames = gameService.getAllGames();
		return SUCCESS;
	}
	
	//initialise la BD en jeux
	public String firstGames(){
		Game g = new Game("League_of_Legends_(3vs3)", 6);
		gameService.updateGame(g);
		g = new Game("League_of_Legends_(5vs5)", 10);
		gameService.updateGame(g);
		g = new Game("Hearthstone", 2);
		gameService.updateGame(g);
		g = new Game("Starcraft_2", 2);
		gameService.updateGame(g);
		g = new Game("Counter_Strike", 10);
		gameService.updateGame(g);
		g = new Game("Fifa_15", 2);
		gameService.updateGame(g);
		g = new Game("Dota_2", 2);
		gameService.updateGame(g);
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
