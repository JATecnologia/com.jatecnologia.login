package com.jatecnologia.login.web.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jatecnologia.login.core.entity.JatUser;

@Stateless
public class LoginService {
	  @PersistenceContext
	  private EntityManager em;
	  
	  public JatUser findByLoginAndPassword(String login, String password){
		  Query query  = em.createQuery("SELECT u FROM JatUser u WHERE u.login = :login AND u.password = :password");
		  
		  query.setParameter("login", login);
		  query.setParameter("password", password);
		  
		  try{
			  return (JatUser) query.getSingleResult();
		  }catch (NoResultException ex){
			  return null;
		  }																																																																																																																																																																																													  
	  }
	  
}																																																																																						
