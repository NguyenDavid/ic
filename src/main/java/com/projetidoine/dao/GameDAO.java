package com.projetidoine.dao;

import java.util.List;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;

/**
 * 
 * GameDAO est l'interface qui regroupe les differentes methodes de la couche
 * d'acces au donnees des games
 *
 */
public interface GameDAO {
	/**
	 * Ajoute un jeu
	 * 
	 * @param game
	 *            l'objet game
	 */
	public void addGame(Game game);
	
	/**
	 * Recupere la liste de tous les jeux
	 * 
	 * @return retourne liste des jeux
	 */
	public List<Game> getAllGames();
	
	/**
	 * permet de recuperer un jeu en se basant sur son id
	 * 
	 * @param idGame
	 *            id du jeu
	 */
	public Game getGameById(Long idGame);
	
	/**
	 * permet de modifier un jeu
	 * 
	 * @param game
	 *            objet jeu a modifier
	 */
	public void updateGame(Game game);
	
	/**
	 * permet de supprimer un jeu
	 * 
	 * @param idGame
	 *            id du jeu
	 */
	public void deleteGame(Long idGame);
	
	/**
	 * permet de recuperer la liste d'evenements d'un jeu
	 * 
	 * @param idGame
	 *            id du jeu
	 */
	public List<Event> getEventsByGameId(Long idGame);
}
