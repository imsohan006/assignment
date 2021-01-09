package com.tatsam.assignment.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tatsam.assignment.dao.PriorityDaoRepository;
import com.tatsam.assignment.entity.Priority;

/**
 * 
 * @author Sohan Yadav
 * @implNote: Priority DAO layer implementations
 */

@Service
@Transactional
public class PriorityDaoImpl implements PriorityDaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Priority> findAll() {
		try {
			Query q = entityManager.createQuery("FROM Priority");
			List<Priority> list = q.getResultList();
			return list;
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Priority> findByUser(String user) {
		try {
			Query q = entityManager.createQuery("FROM Priority WHERE user =: user");
			q.setParameter("user",user);
			List<Priority> list = q.getResultList();
			return list;
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addPriorityWithSatification(Priority priority) {
		try{
			entityManager.persist(priority);
		} catch (Exception e) {
			return null;
		}
		return "Created";
	}
	
	

}
