package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.EventDAO;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

public class EventServiceImpl implements EventService {
	private EventDAO eventDAO;
	
	@Transactional
	public void addEvent(Event event){
		eventDAO.addEvent(event);
	}
	
	@Transactional(readOnly = true)
	public List<Event> getAllEvents(){
		return eventDAO.getAllEvents();
	}
	
	@Transactional(readOnly = true)
	public Event getEventById(Long idEvent){
		return eventDAO.getEventById(idEvent);
	}
	
	@Transactional
	public void updateEvent(Event event){
		eventDAO.updateEvent(event);
	}
	
	@Transactional
	public void deleteEvent(Long idEvent){
		eventDAO.deleteEvent(idEvent);
	}
	
	public void setEventDAO(EventDAO eventDAO){
		this.eventDAO = eventDAO;
	}
	
	@Transactional
	public void addPlayerInEvent(User user, Long idEvent){
		this.eventDAO.addPlayerInEvent(user, idEvent);
	}
	
	@Transactional(readOnly = true)
	public List<Event> getEventByIdUser(Long idUser){
		return this.eventDAO.getEventByIdUser(idUser);
	}
	
	@Transactional(readOnly = true)
	public List<Event> getOtherEventsByIdUser(Long idUser){
		return this.eventDAO.getOtherEventsByIdUser(idUser);
	}
}
