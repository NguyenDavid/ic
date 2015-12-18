package com.projetidoine.dao;

import java.util.List;

import com.projetidoine.entity.User;

/**
 * 
 * UserDAO est l'interface qui regroupe les differentes methodes de la couche
 * d'accees au donnees des users
 *
 */
public interface UserDAO {
	/**
	 * Ajoute un utilisateur de l'application
	 * 
	 * @param user
	 *            l'objet user
	 */
	public void addUser(User user);

	/**
	 * Recupere la liste de tous les utilisateurs de l'application
	 * 
	 * @return retourne liste des utilisateurs
	 */
	public List<User> getAllUsers();

	/**
	 * Recupere la liste de tous les utilisateurs de l'application sauf celui
	 * connecte'
	 * 
	 * @param nom
	 *            nom de l'utilisateur connecte
	 * @return retourne liste des utilisateurs
	 */
	public List<User> getOtherUsers(String nom);

	/**
	 * permet de recuperer un utilisateur en se basant sur son login
	 * 
	 * @param login
	 *            login de l'utilisateur
	 */
	public User getUserByLogin(String login);

	/**
	 * permet de recuperer un utilisateur en se basant sur son id
	 * 
	 * @param login
	 *            id de l'utilisateur
	 */
	public User getUserById(Long idUser);

	/**
	 * permet de modifier un utilisateur
	 * 
	 * @param user
	 *            objet utilisateur a modifier
	 */
	public void updateUser(User user);

	/**
	 * permet de supprimer un utilisateur
	 * 
	 * @param idUser
	 *            id de l'utilisateur
	 */
	public void deleteUser(Long idUser);
}