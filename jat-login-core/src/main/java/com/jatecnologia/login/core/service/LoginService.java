package com.jatecnologia.login.core.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jatecnologia.login.core.entity.JATUser;

@Stateless
public class LoginService {
	  @PersistenceContext
	  private EntityManager em;
	  
	  public JATUser findByLoginAndPassword(String login){
		  Query query  = em.createQuery("SELECT u FROM JATUser u WHERE u.login = :login");
		  
		  query.setParameter("login", login);
		  
		  try{
			  return (JATUser) query.getSingleResult();
		  }catch (NoResultException ex){
			  return null;
		  }																																																																																																																																																																																													  
	  }

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	} 
	  
}																																																																																						
