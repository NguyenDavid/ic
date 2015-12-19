package com.projetidoine.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.Event;

@Repository
public class EventDAOImpl implements EventDAO {
	/**
	 * La variable sessionFactory est injecte par Spring
	 */
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addEvent(Event event){
		this.sessionFactory.getCurrentSession().save(event);
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents(){
		return this.sessionFactory.getCurrentSession().createQuery("from Event").list();
	}
	
	public Event getEventById(Long idEvent){
		return (Event) this.sessionFactory.getCurrentSession().get(Event.class, idEvent);
	}
	
	public void updateEvent(Event event){
		this.sessionFactory.getCurrentSession().merge(event);
	}
	
	public void deleteEvent(Long idEvent){
		this.sessionFactory.getCurrentSession().delete(getEventById(idEvent));
	}
}
