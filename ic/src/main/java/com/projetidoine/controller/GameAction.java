package com.projetidoine.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Game;
import com.projetidoine.service.GameService;

public class GameAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Game game;
	private Long idGame;
	private GameService gameService;
	private List<Game> listGames = new ArrayList<Game>();
	
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
	
	public String listGames(){
		listGames = gameService.getAllGames();
		return SUCCESS;
	}
	
	//initialise la BD en jeux
	public String firstGames(){
		Game g = new Game("League of Legends (3vs3)", 6);
		gameService.updateGame(g);
		g = new Game("League of Legends (5vs5)", 10);
		gameService.updateGame(g);
		g = new Game("Hearthstone", 2);
		gameService.updateGame(g);
		g = new Game("Starcraft 2", 2);
		gameService.updateGame(g);
		g = new Game("Counter Strike", 10);
		gameService.updateGame(g);
		g = new Game("Fifa 15", 2);
		gameService.updateGame(g);
		g = new Game("Dota 2", 2);
		gameService.updateGame(g);
		return SUCCESS;
	}
}
