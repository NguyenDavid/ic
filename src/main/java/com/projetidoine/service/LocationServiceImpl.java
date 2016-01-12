package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.LocationDAO;
import com.projetidoine.entity.Location;

public class LocationServiceImpl implements LocationService {
	private LocationDAO locationDAO;
	
	@Transactional
	public void addLocation(Location location) {
		locationDAO.addLocation(location);
	}

	@Transactional(readOnly = true)
	public List<Location> getAllLocations() {
		return locationDAO.getAllLocations();
	}

	@Transactional(readOnly = true)
	public Location getLocationById(Long idLocation) {
		return locationDAO.getLocationById(idLocation);
	}

	@Transactional
	public void updateLocation(Location location) {
		locationDAO.updateLocation(location);
	}

	@Transactional
	public void deleteLocation(Long idLocation) {
		locationDAO.deleteLocation(idLocation);
	}
	
	public void setLocationDAO(LocationDAO locationDAO){
		this.locationDAO = locationDAO;
	}
}