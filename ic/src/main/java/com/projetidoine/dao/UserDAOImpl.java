package com.projetidoine.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.projetidoine.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	/**
	 * La variable sessionFactory est injectee par Spring
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	public List<User> getOtherUsers(String nom) {
		List<User> users = this.sessionFactory.getCurrentSession()
				.createQuery("from User u where u.login <> :login ")
				.setString("login", nom).list();
		return users;
	}

	public User getUserByLogin(String login) {
		return (User) this.sessionFactory.getCurrentSession()
				.createQuery("from User u where u.login= :login ")
				.setString("login", login).uniqueResult();
	}

	public User getUserById(Long idUser) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class,
				idUser);
	}

	public void updateUser(User user) {
		this.sessionFactory.getCurrentSession().merge(user);
	}

	public void deleteUser(Long idUser) {
		this.sessionFactory.getCurrentSession().delete(getUserById(idUser));
	}
}
