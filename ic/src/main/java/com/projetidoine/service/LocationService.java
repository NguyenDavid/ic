package com.projetidoine.service;

import java.util.List;

import com.projetidoine.entity.Location;

public interface LocationService {
	public void addLocation(Location location);
	
	public List<Location> getAllLocations();
	
	public Location getLocationById(Long idLocation);
	
	public void updateLocation(Location location);
	
	public void deleteLocation(Long idLocation);
}
