package com.projetidoine.dao;

import java.util.List;

import com.projetidoine.entity.Location;

/**
 * 
 * LocationDAO est l'interface qui regroupe les differentes methodes de la couche
 * d'acces au donnees des locations
 *
 */
public interface LocationDAO {
	/**
	 * Ajoute un lieu
	 * 
	 * @param location
	 *            l'objet location
	 */
	public void addLocation(Location location);
	
	/**
	 * Recupere la liste de tous les lieux
	 * 
	 * @return retourne liste des lieux
	 */
	public List<Location> getAllLocations();
	
	/**
	 * permet de recuperer un lieu en se basant sur son id
	 * 
	 * @param idLocation
	 *            id du lieu
	 */
	public Location getLocationById(Long idLocation);
	
	/**
	 * permet de modifier un lieu
	 * 
	 * @param location
	 *            objet location a modifier
	 */
	public void updateLocation(Location location);
	
	/**
	 * permet de supprimer un lieu
	 * 
	 * @param idLocation
	 *            id du lieu
	 */
	public void deleteLocation(Long idLocation);
}
