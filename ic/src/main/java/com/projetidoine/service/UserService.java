package com.projetidoine.service;

import java.util.List;

import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

public interface UserService {
	public void addUser(User user);

	public List<User> getAllUsers();

	public List<User> getOtherUsers(String nom);

	public User getUserByLogin(String login);

	public User getUserById(Long idUser);

	public void updateUser(User user);

	public void deleteUser(Long idUser);
	
	public List<Event> getEventsByUserId(Long id);
}
