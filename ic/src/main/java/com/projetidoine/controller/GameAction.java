package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Game;
import com.projetidoine.service.GameService;

public class GameAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Game game;
	private Long idGame;
	private GameService gameService;
	
	public void prepare() throws Exception {
		this.game = null;
		this.idGame = null;
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
	
	//initialise la BD en jeux
	public String firstGames(){
		Game g = new Game("League of Legends");
		gameService.updateGame(g);
		g = new Game("Hearthstone");
		gameService.updateGame(g);
		g = new Game("Starcraft 2");
		gameService.updateGame(g);
		g = new Game("Counter Strike");
		gameService.updateGame(g);
		g = new Game("Fifa 15");
		gameService.updateGame(g);
		g = new Game("DOTA 2");
		gameService.updateGame(g);
		return SUCCESS;
	}
}
