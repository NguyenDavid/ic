package com.projetidoine.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVENT")
	private Long idEvent;
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;
	@Column(name = "DATE", nullable = false)
	private Date date;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="events")
	private List<User> users;
	@ManyToOne
	private Game game;
	@ManyToOne
	private Location location;

	public Event(){
	}
	
	public Event(String description, Game game){
		super();
		this.description = description;
		this.game = game;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(List<User> users){
		this.users = users;
	}
	
	public Game getGame(){
		return this.game;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	public void setLocation(Location location){
		this.location = location;
	}
}
