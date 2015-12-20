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
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LOCATION")
	private Long idLocation;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	@OneToMany(mappedBy="location")
	@Column(nullable = true)
	private List<Game> games;
	
	public Location(){
	}
	
	public Location(String name, String address){
		super();
		this.name = name;
		this.address = address;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public List<Game> getGames(){
		return this.games;
	}
	
	public void setGames(List<Game> games){
		this.games = games;
	}
}
