package com.projetidoine.dao;

import java.util.List;

import com.projetidoine.entity.Event;

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
}
