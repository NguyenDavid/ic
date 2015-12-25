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
	
	@SuppressWarnings("unchecked")
	public void addPlayerInEvent(User user, Long idEvent){
		System.out.println("EventDaoImpl");
		List<Event> listEvents = new ArrayList<Event>();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Event e where e.idEvent = :idEvent");
		query.setParameter("idEvent", idEvent);
		listEvents = query.list();
		if(listEvents.size() > 0){
			Event e = listEvents.get(0);
			List<User> listUsers = e.getUsers();
			System.out.println("Ancien event : "+e.getUsers().size()+" "+e.getNbPlayers());
			if(!listUsers.contains(user)){
				listUsers.add(user);
				e.setUsers(listUsers);
				e.setNbPlayers(listUsers.size());
				
				System.out.println("New event : "+e.getUsers().size()+" "+e.getNbPlayers());
				System.out.println("il y a un probleme dans le saveOrUpdate d'Hibernate");
				this.sessionFactory.getCurrentSession().saveOrUpdate(e);
				System.out.println("eventDaoImpl fin");
			}
		}
		
//		List<Category> categoryList = new ArrayList<Category>();
//		Query query = getSession().createQuery("from Category c where c.nom = :nom");
//		query.setParameter("nom", nom);
//		categoryList = query.list();
//		if (categoryList.size() > 0)
//			return categoryList.get(0);
//		else
//			return null;
	}
}
