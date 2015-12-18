package com.projetidoine.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.projetidoine.dao.UserDAO;
import com.projetidoine.entity.User;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	@Transactional
	public User getUserByLogin(String login) {
		return userDAO.getUserByLogin(login);
	}

	@Override
	@Transactional
	public User getUserById(Long idUser) {
		return userDAO.getUserById(idUser);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(Long idUser) {
		userDAO.deleteUser(idUser);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> getOtherUsers(String nom) {
		return userDAO.getOtherUsers(nom);
		
	}
}
