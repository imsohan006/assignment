package com.tatsam.assignment.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tatsam.assignment.dao.UserDaoRepository;
import com.tatsam.assignment.entity.User;

/**
 * 
 * @author Sohan Yadav
 * @implNote: User DAO layer implementations
 */

@Service
@Transactional
public class UserDaoImpl implements UserDaoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String addUser(User user) {
		try{
			entityManager.persist(user);
		} catch (Exception e) {
			return null;
		}
		return "Created";
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addIfNotExist(User user) {
		boolean isAvaliable = userExists(user.getUser());
		if(isAvaliable) {
			return "user already exist";
		} else {
			return addUser(user)==null?null:"user created with id : "+user.getId();
		}
	}

	@Override
	public boolean userExists(String username) {
		try {
			Query q = entityManager.createQuery("FROM User WHERE user =: username");
			q.setParameter("username", username);
			q.getSingleResult();
			return true;
		}catch (NoResultException noResultException) {
			return false;
		}catch (Exception ex) {
			return true;
		}
	}

	@Override
	public User findByUser(String username) {
		try {
			Query q = entityManager.createQuery("FROM User WHERE user =: username");
			q.setParameter("username", username);
			return (User) q.getSingleResult();
		}catch (Exception ex) {
			return null;
		}
	}

}
