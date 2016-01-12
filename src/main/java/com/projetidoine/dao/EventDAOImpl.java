package com.projetidoine.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
		Event e = (Event) this.sessionFactory.getCurrentSession().createQuery("from Event e where e.idEvent = "+idEvent).uniqueResult();
		
		boolean containsUser = false;
		for (User u : e.getUsers()) {
			if(u.getIdUser().equals(user.getIdUser())){
				containsUser = true;
				break;
			}
		}
		
		if(!containsUser && e.getNbPlayers()<e.getNbMaxPlayers()){
			System.out.println("-----AVANT-----");
			System.out.println("Date : "+e.getDate());
			System.out.println("Description : "+e.getDescription());
			System.out.println("Game : "+e.getGame().getName());
			System.out.println("Location : "+e.getLocation().getName());
			System.out.println("NbMaxPlayers : "+e.getNbMaxPlayers());
			System.out.println("NbPlayers : "+e.getNbPlayers());
			System.out.println("size : "+e.getUsers().size());
			
			e.getUsers().add(user);
			e.setNbPlayers(e.getUsers().size());
			
			System.out.println("-----APRES-----");
			System.out.println("Date : "+e.getDate());
			System.out.println("Description : "+e.getDescription());
			System.out.println("Game : "+e.getGame().getName());
			System.out.println("Location : "+e.getLocation().getName());
			System.out.println("NbMaxPlayers : "+e.getNbMaxPlayers());
			System.out.println("NbPlayers : "+e.getNbPlayers());
			System.out.println("size : "+e.getUsers().size());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEventByIdUser(Long idUser){
		List<Event> listEvents = new ArrayList<Event>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("select e from User u, Event e where u.idUser = :idUser and e in elements(u.events)");
		query.setParameter("idUser", idUser);
		listEvents = query.list();
		return listEvents;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getOtherEventsByIdUser(Long idUser){
		List<Event> listEvents = new ArrayList<Event>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("select e from User u, Event e where u.idUser = :idUser and e not in elements(u.events)");
		query.setParameter("idUser", idUser);
		listEvents = query.list();
		return listEvents;
	}
}
