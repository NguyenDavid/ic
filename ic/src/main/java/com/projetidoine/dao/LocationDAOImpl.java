package com.projetidoine.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.Location;

@Repository
public class LocationDAOImpl implements LocationDAO {
	/**
	 * La variable sessionFactory est injectee par Spring
	 */
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addLocation(Location location) {
		this.sessionFactory.getCurrentSession().save(location);
	}

	@SuppressWarnings("unchecked")
	public List<Location> getAllLocations() {
		return this.sessionFactory.getCurrentSession().createQuery("from Location").list();
	}

	public Location getLocationById(Long idLocation) {
		return (Location) this.sessionFactory.getCurrentSession().get(Location.class, idLocation);
	}

	public void updateLocation(Location location) {
		this.sessionFactory.getCurrentSession().merge(location);
	}

	public void deleteLocation(Long idLocation) {
		this.sessionFactory.getCurrentSession().delete(getLocationById(idLocation));
	}
}