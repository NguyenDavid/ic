package com.projetidoine.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

@Repository
public class EventDAOImpl implements EventDAO {
	/**
	 * La variable sessionFactory est injectee par Spring
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
	
	public void addPlayerInEvent(User user, Long idEvent){
		System.out.println("EventDaoImpl");
		
		Event e = (Event) this.sessionFactory.getCurrentSession().createQuery("from Event e where e.idEvent = "+idEvent).uniqueResult();
		System.out.println("Ancien event : "+e.getUsers().size()+" "+e.getNbPlayers());
//		if(e != null){
//			Event newEvent = new Event();
//			newEvent.setDate(e.getDate());
//			newEvent.setDescription(e.getDescription());
//			newEvent.setGame(e.getGame());
//			newEvent.setIdEvent(idEvent);
//			newEvent.setLocation(e.getLocation());
//			newEvent.setNbMaxPlayers(e.getNbMaxPlayers());
//			
//			List<User> users = new ArrayList<User>(e.getUsers());
//			users.add(user);
//			newEvent.setUsers(users);
//			newEvent.setNbPlayers(users.size());
//			
//			this.sessionFactory.getCurrentSession().delete(e);
////			//a enlever
////			e = null;
//			System.out.println("New event : "+newEvent.getDate()+" "+newEvent.getDescription()+" "+newEvent.getGame()+" "+newEvent.getIdEvent()+" "+newEvent.getLocation()+" "+newEvent.getNbMaxPlayers());
//			System.out.println("New event : "+newEvent.getUsers().size()+" "+newEvent.getNbPlayers());
//			this.sessionFactory.getCurrentSession().save(newEvent);
		
		if(e != null){
			Event newEvent = new Event();
			newEvent.setDate((Date)e.getDate().clone());//e.getDate());
			newEvent.setDescription(new String(e.getDescription()));
			newEvent.setGame(e.getGame().clone());
			newEvent.setIdEvent(idEvent);
			newEvent.setLocation(e.getLocation().clone());
			newEvent.setNbMaxPlayers(e.getNbMaxPlayers());
			
			List<User> users = new ArrayList<User>(e.getUsers());
			users.add(user);
			newEvent.setUsers(users);
			newEvent.setNbPlayers(users.size());
			
//			this.sessionFactory.getCurrentSession().delete(e);
//			System.out.println("New event : "+newEvent.getDate()+" "+newEvent.getDescription()+" "+newEvent.getGame()+" "+newEvent.getIdEvent()+" "+newEvent.getLocation()+" "+newEvent.getNbMaxPlayers());
//			System.out.println("New event : "+newEvent.getUsers().size()+" "+newEvent.getNbPlayers());
//			this.sessionFactory.getCurrentSession().save(newEvent);
		}
		
		
	}
}
