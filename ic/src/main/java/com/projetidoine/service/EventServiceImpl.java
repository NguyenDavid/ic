package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.EventDAO;
import com.projetidoine.entity.Event;

public class EventServiceImpl implements EventService {
	private EventDAO eventDAO;
	
	@Transactional
	public void addEvent(Event event){
		eventDAO.addEvent(event);
	}
	
	@Transactional
	public List<Event> getAllEvents(){
		return eventDAO.getAllEvents();
	}
	
	@Transactional
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
}
