package com.projetidoine.dao;

import java.util.List;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

/**
 * 
 * EventDAO est l'interface qui regroupe les differentes methodes de la couche
 * d'acces au donnees des events
 *
 */
public interface EventDAO {
	/**
	 * Ajoute un evenement
	 * 
	 * @param event
	 *            l'objet event
	 */
	public void addEvent(Event event);
	
	/**
	 * Recupere la liste de tous les evenements
	 * 
	 * @return retourne liste des evenements
	 */
	public List<Event> getAllEvents();
	
	/**
	 * permet de recuperer un evenement en se basant sur son id
	 * 
	 * @param idEvent
	 *            id de l'evenement
	 */
	public Event getEventById(Long idEvent);
	
	/**
	 * permet de modifier un evenement
	 * 
	 * @param event
	 *            objet evenement a modifier
	 */
	public void updateEvent(Event event);
	
	/**
	 * permet de supprimer un evenement
	 * 
	 * @param idEvent
	 *            id de l'evenement
	 */
	public void deleteEvent(Long idEvent);
	
	/**
	 * permet d'ajouter un joueur a un evenement
	 * 
	 * @param idEvent
	 *            id de l'evenement
	 */
	public void addPlayerInEvent(User user, Long idEvent);
	
	/**
	 * permet de recuperer une liste d'evenement d'un utilisateur
	 * 
	 * @param idUser
	 *            id de l'utilisateur
	 */
	public List<Event> getEventByIdUser(Long idUser);
}
