package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.UserDAO;
import com.projetidoine.entity.Event;
import com.projetidoine.entity.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional(readOnly = true)
	public User getUserByLogin(String login) {
		return userDAO.getUserByLogin(login);
	}

	@Transactional(readOnly = true)
	public User getUserById(Long idUser) {
		return userDAO.getUserById(idUser);
	}

	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Transactional
	public void deleteUser(Long idUser) {
		userDAO.deleteUser(idUser);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional(readOnly = true)
	public List<User> getOtherUsers(String nom) {
		return userDAO.getOtherUsers(nom);
	}
	
	@Transactional(readOnly = true)
	public List<Event> getEventsByUserId(Long id){
		return userDAO.getEventsByUserId(id);
	}
}
