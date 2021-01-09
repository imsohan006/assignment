package com.tatsam.assignment.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tatsam.assignment.dao.AreaDaoRepository;
import com.tatsam.assignment.entity.Areas;

/**
 * 
 * @author sohan
 * @implNote: Area DAO layer implementations
 */

@Service
@Transactional
public class AreaDaoImpl implements AreaDaoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String saveAreaIfNotExist(Areas area) {
		boolean isAvaliable = isAreaAvaliable(area.getArea());
		if(isAvaliable) {
			return "area already exist";
		} else {
			return saveArea(area)==null?null:"area created with id : "+area.getId();
		}
	}

	
	@Override
	public boolean isAreaAvaliable(String area) {
		try {
			Query q = entityManager.createQuery("FROM Areas WHERE area =:area");
			q.setParameter("area", area);
			q.getSingleResult();
			return true;
		}catch (NoResultException noResultException) {
			return false;
		}catch (Exception ex) {
			return true;
		}
	}


	@Override
	public String saveArea(Areas area) {
		try{
			entityManager.persist(area);
		} catch (Exception e) {
			return null;
		}
		return "Created";
	}

}
