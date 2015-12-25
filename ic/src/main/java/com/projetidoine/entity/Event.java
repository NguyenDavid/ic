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
	@Column(name = "NBPLAYERS", nullable = false)
	private int nbPlayers;
	@Column(name = "NBMAXPLAYERS", nullable = false)
	private int nbMaxPlayers;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="events")
	private List<User> users;
	@ManyToOne
	private Game game;
	@ManyToOne
	private Location location;

	public Event(){
	}
	
	public Event(String description, Date date, int nbPlayers, int nbMaxPlayers, Game game, Location location){
		super();
		this.description = description;
		this.date = date;
		this.nbPlayers = nbPlayers;
		this.nbMaxPlayers = nbMaxPlayers;
		this.game = game;
		this.location = location;
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
	
	public int getNbPlayers(){
		return this.nbPlayers;
	}
	
	public void setNbPlayers(int nbPlayers){
		this.nbPlayers = nbPlayers;
	}
	
	public int getNbMaxPlayers(){
		return this.nbMaxPlayers;
	}
	
	public void setNbMaxPlayers(int nbMaxPlayers){
		this.nbMaxPlayers = nbMaxPlayers;
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(List<User> users){
		this.users = users;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
