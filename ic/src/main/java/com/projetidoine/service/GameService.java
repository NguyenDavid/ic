package com.projetidoine.service;

import java.util.List;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;

public interface GameService {
public void addGame(Game game);
	
	public List<Game> getAllGames();
	
	public Game getGameById(Long idGame);
	
	public void updateGame(Game game);
	
	public void deleteGame(Long idGame);
	
	public List<Event> getEventsByGameId(Long idGame);
}
