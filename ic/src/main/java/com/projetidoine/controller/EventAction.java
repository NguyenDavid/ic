package com.projetidoine.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.projetidoine.entity.Event;
import com.projetidoine.service.EventService;

public class EventAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;
	private Event event;
	private Long idEvent;
	private EventService eventService;
	
	public void prepare() throws Exception {
		this.event = null;
		this.idEvent = null;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Long getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	public String saveEvent(){
//		eventService.addEvent(event);
		System.out.println("EventAction : saveEvent");
		return SUCCESS;
	}
}
