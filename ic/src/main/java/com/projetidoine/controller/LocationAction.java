package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Location;
import com.projetidoine.service.LocationService;

public class LocationAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Location location;
	private Long idLocation;
	private LocationService locationService;
	
	public void prepare() throws Exception {
		this.location = null;
		this.idLocation = null;
	}
	
	public String saveLocation(){
		locationService.addLocation(location);
		return SUCCESS;
	}
	
	public Location getLocation(){
		return location;
	}
	
	public void setLocation(Location location){
		this.location = location;
	}
	
	public Long getIdLocation(){
		return idLocation;
	}
	
	public void setIdLocation(Long idLocation){
		this.idLocation = idLocation;
	}
	
	public void setLocationService(LocationService locationService){
		this.locationService = locationService;
	}
	
	//initialise la BD en lieux
	public String firstLocations(){
		Location l = new Location("Palais des sports de Lyon", "350 avenue Jean Jaurès, 69007 Lyon");
		l = new Location("Meltdown - Montpellier", "60 bis avenue du Pont Juvenal, 34000 Montpellier");
		locationService.updateLocation(l);
		l = new Location("Meltdown - Lille", "6 rue du Faisan, 59000 Lille");
		locationService.updateLocation(l);
		l = new Location("Meltdown - Bordeaux", "129 cours d'Albret, 33000 Bordeaux");
		locationService.updateLocation(l);
		l = new Location("Insalan", "20 avenue des Buttes de Coësmes, 35708 Rennes");
		locationService.updateLocation(l);
		l = new Location("Vinci Centre International de Congrès de Tours", "26 Boulevard Heurteloup, 37000 Tours");
		locationService.updateLocation(l);
		l = new Location("Stade des Lumières", "Chemin du Montout, 69150 Décines-Charpieu");
		locationService.updateLocation(l);
		return SUCCESS;
	}
}
