package com.projetidoine.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "NAME", unique = true, nullable = false)
	private String name;
	@Column(name = "NBPLAYERSPERMATCH", nullable = false)
	private int nbPlayersPerMatch;
	//@OneToMany(mappedBy="game", fetch = FetchType.EAGER)
	//@Column(nullable = true)
	//@OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	@Column(nullable = true)
	private List<Event> events;
	
	public Game(){
	}
	
	public Game(String name, int nbPlayersPerMatch){
		super();
		this.name = name;
		this.nbPlayersPerMatch = nbPlayersPerMatch;
	}
	
	public Game clone(){
		Game g = new Game();
		g.setIdGame(this.getIdGame());
		g.setName(new String(this.getName()));
		g.setNbPlayersPerMatch(this.getNbPlayersPerMatch());
		g.setEvents(new ArrayList<Event>(this.getEvents()));
		return g;
	}
	
	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
	}

	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getNbPlayersPerMatch(){
		return this.nbPlayersPerMatch;
	}
	
	public void setNbPlayersPerMatch(int nbPlayersPerMatch){
		this.nbPlayersPerMatch = nbPlayersPerMatch;
	}
	
	public List<Event> getEvents(){
		return this.events;
	}
	
	public void setEvents(List<Event> events){
		this.events = events;
	}
}
