package com.projetidoine.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GAME")
	private Long idGame;
	@Column(name = "NAME", nullable = false)
	private String name;
	@OneToMany(mappedBy="game")
	@Column(nullable = true)
	private List<Event> events;
	
	public Game(){
	}
	
	public Game(String name){
		super();
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public List<Event> getEvents(){
		return this.events;
	}
	
	public void setEvents(List<Event> events){
		this.events = events;
	}
}
