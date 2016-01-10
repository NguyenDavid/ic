package com.projetidoine.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.Game;

@Repository
public class GameDAOImpl implements GameDAO {
	/**
	 * La variable sessionFactory est injectee par Spring
	 */
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addGame(Game game) {
		this.sessionFactory.getCurrentSession().save(game);
	}

	@SuppressWarnings("unchecked")
	public List<Game> getAllGames() {
		return this.sessionFactory.getCurrentSession().createQuery("from Game").list();
	}

	public Game getGameById(Long idGame) {
		return (Game) this.sessionFactory.getCurrentSession().get(Game.class, idGame);
	}

	public void updateGame(Game game) {
		this.sessionFactory.getCurrentSession().merge(game);
	}

	public void deleteGame(Long idGame) {
		this.sessionFactory.getCurrentSession().delete(getGameById(idGame));
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getEventsByGameId(Long idGame){
		List<Event> listEvents = (List<Event>) this.sessionFactory.getCurrentSession().createQuery("select g.events from Game g where g.idGame= :idGame")
				.setLong("idGame", idGame);
		if(listEvents.size() > 0)
			return listEvents;
		return null;
	}
}
