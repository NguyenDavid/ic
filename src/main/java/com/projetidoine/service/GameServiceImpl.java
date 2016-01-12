package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.GameDAO;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;

public class GameServiceImpl implements GameService {
	private GameDAO gameDAO;

	@Transactional
	public void addGame(Game game) {
		gameDAO.addGame(game);
	}

	@Transactional(readOnly = true)
	public List<Game> getAllGames() {
		return gameDAO.getAllGames();
	}

	@Transactional(readOnly = true)
	public Game getGameById(Long idGame) {
		return gameDAO.getGameById(idGame);
	}

	@Transactional
	public void updateGame(Game game) {
		gameDAO.updateGame(game);
	}

	@Transactional
	public void deleteGame(Long idGame) {
		gameDAO.deleteGame(idGame);
	}
	
	public void setGameDAO(GameDAO gameDAO){
		this.gameDAO = gameDAO;
	}
	
	@Transactional(readOnly = true)
	public List<Event> getEventsByGameId(Long idGame){
		return this.gameDAO.getEventsByGameId(idGame);
	}
}