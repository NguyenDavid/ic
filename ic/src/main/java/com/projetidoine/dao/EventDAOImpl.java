package com.projetidoine.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;
import com.projetidoine.entity.Location;
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
	
//	@SuppressWarnings("unchecked")
	public void addPlayerInEvent(User user, Long idEvent){
		System.out.println("EventDaoImpl");
		
		Event e = (Event) this.sessionFactory.getCurrentSession().createQuery("from Event e where e.idEvent = "+idEvent).uniqueResult();
		
		if(!e.getUsers().contains(user)){
			System.out.println("-----AVANT-----");
			System.out.println("Date : "+e.getDate());
			System.out.println("Description : "+e.getDescription());
			System.out.println("Game : "+e.getGame().getName());
			System.out.println("Location : "+e.getLocation().getName());
			System.out.println("NbMaxPlayers : "+e.getNbMaxPlayers());
			System.out.println("NbPlayers : "+e.getNbPlayers());
			System.out.println("size : "+e.getUsers().size());
			
//			List<User> users = e.getUsers();
//			users.add(user);
//			e.setUsers(users);
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
			
			System.out.println("eventDaoImpl : avant merge");
			this.sessionFactory.getCurrentSession().merge(e);
			System.out.println("eventDaoImpl : apres merge");
		}
		
//		if(e != null){
//			//prendre les autres entites liees a cet event
//			//mettre l'event a null vis-a-vis d'eux
//			//save du cote de l'entite
//			//save du cote de l'event
//			//add event
//			//changer du cote de chaque entite
//			
//			Event newEvent = new Event();
//			newEvent.setDate((Date)e.getDate().clone());
//			newEvent.setDescription(new String(e.getDescription()));
//			newEvent.setGame(e.getGame().clone());
//			newEvent.setIdEvent(idEvent);
//			newEvent.setLocation(e.getLocation().clone());
//			newEvent.setNbMaxPlayers(e.getNbMaxPlayers());
//			
//			List<User> users = new ArrayList<User>(e.getUsers());
//			users.add(user);
//			newEvent.setUsers(users);
//			newEvent.setNbPlayers(users.size());
//			
//			System.out.println("New event : "+newEvent.getDate()+" "+newEvent.getDescription()+" "+newEvent.getGame()+" "+newEvent.getIdEvent()+" "+newEvent.getLocation()+" "+newEvent.getNbMaxPlayers());
//			System.out.println("New event : "+newEvent.getUsers().size()+" "+newEvent.getNbPlayers());
//			
//			List<Game> listGames = new ArrayList<Game>();
//			Query queryGame = this.sessionFactory.getCurrentSession().createQuery("from Game g where g.name = :name");
//			queryGame.setParameter("name", e.getGame().getName());
//			listGames = queryGame.list();
//			for (Game game : listGames) {
//				List<Event> listEventsGame = game.getEvents();
//				listEventsGame.remove(e);
//				listEventsGame.add(newEvent);
//				game.setEvents(listEventsGame);
//				this.sessionFactory.getCurrentSession().save(game);
//			}
//			
//			List<Location> listLocations = new ArrayList<Location>();
//			Query queryLocation = this.sessionFactory.getCurrentSession().createQuery("from Location l where l.name = :name");
//			queryLocation.setParameter("name", e.getLocation().getName());
//			listLocations = queryLocation.list();
//			for (Location location : listLocations) {
//				List<Event> listEventsLocation = location.getEvents();
//				listEventsLocation.remove(e);
//				listEventsLocation.add(newEvent);
//				location.setEvents(listEventsLocation);
//				this.sessionFactory.getCurrentSession().save(location);
//			}
//			
//			List<User> listUsers = new ArrayList<User>();
//			Query queryUser = this.sessionFactory.getCurrentSession().createQuery("from User u where :e in elements(u.events)");
//			queryUser.setParameter("e", e);
//			listUsers = queryUser.list();
//			for (User u : listUsers) {
//				List<Event> listEventsUser = u.getEvents();
//				listEventsUser.remove(e);
//				listEventsUser.add(newEvent);
//				u.setEvents(listEventsUser);
//				System.out.println("eventDAOImpl i");
//				this.sessionFactory.getCurrentSession().save(u);
//			}
//			
//			System.out.println("quasi fin eventDAOImpl");
//			
//			this.sessionFactory.getCurrentSession().merge(newEvent);
//			
//			System.out.println("fin eventDAOImpl");
//		}
	}
}
