package com.projetidoine.service;

import java.util.List;

import com.projetidoine.entity.Event;

public interface EventService {
	public void addEvent(Event event);
	
	public List<Event> getAllEvents();
	
	public Event getEventById(Long idEvent);
	
	public void updateEvent(Event event);
	
	public void deleteEvent(Long idEvent);
}
