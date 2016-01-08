package com.projetidoine.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Cette classe represente un utilisateur de l'application
 * 
 *
 */
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long idUser;
	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	//@ManyToMany(cascade=CascadeType.ALL) 
    //@JoinTable(name="event_user", joinColumns=@JoinColumn(name="ID_USER"), inverseJoinColumns=@JoinColumn(name="ID_EVENT"))
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "event_user", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = { @JoinColumn(name = "id_event") })
	private List<Event> events;

	public User() {
	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User(String login, String email, String password) {
		super();
		this.login = login;
		this.email = email;
		this.password = password;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Event> getEvents(){
		return this.events;
	}
	
	public void setEvents(List<Event> events){
		this.events = events;
	}
}
