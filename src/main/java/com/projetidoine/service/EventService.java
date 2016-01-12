package com.projetidoine.service;

import java.util.List;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

public interface EventService {
	public void addEvent(Event event);
	
	public List<Event> getAllEvents();
	
	public Event getEventById(Long idEvent);
	
	public void updateEvent(Event event);
	
	public void deleteEvent(Long idEvent);
	
	public void addPlayerInEvent(User user, Long idEvent);
	
	public List<Event> getEventByIdUser(Long idUser);
	
	public List<Event> getOtherEventsByIdUser(Long idUser);
}
