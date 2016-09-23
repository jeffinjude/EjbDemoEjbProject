package com.ejbdemo.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.ejbdemo.jpamanager.JpaManager;
import com.ejbdemo.sampleBeans.UserDetails;


/**
 * Session Bean implementation class SampleBizRules
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EjbJpaDao {
	
	//create the entity manager
	@PersistenceContext(unitName = "Hibernate_JPA", type = PersistenceContextType.TRANSACTION)
	EntityManager entityManager = JpaManager.getEntityManagerFactory().createEntityManager();
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertData(String name, String phoneNumber)
	{
			
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName(name);
		userDetails.setPhoneNumber(phoneNumber);
	
		entityManager.persist(userDetails);
	}
}
