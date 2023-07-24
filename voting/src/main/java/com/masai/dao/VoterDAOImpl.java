package com.masai.dao;

import java.util.List;

import com.masai.entity.LoggedInUserId;
import com.masai.entity.Voter;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class VoterDAOImpl implements VoterDAO {

	@Override
	public void addVoter(Voter voter) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if company with same username exists
			Query query = em.createQuery("SELECT count(v) FROM Voter v WHERE name = :uname");
			query.setParameter("uname", voter.getName());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("The username" + voter.getName() + " is already occupied");
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(voter);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT v.id FROM Voter v WHERE name = :username AND password = :password ");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Long> listInt = query.getResultList();
			if(listInt.size() == 0) {
				//you are here means voter with given name does not exists so throw exceptions
				throw new SomethingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT count(v) FROM Voter v WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			Long userCount = (Long)query.getSingleResult();
			if(userCount == 0) {
				//you are here old password is incorrect for logged in user
				throw new SomethingWentWrongException("Invalid old password");
			}
			//You are here means all checks done, We can proceed for changing the password
			Voter voter = em.find(Voter.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			voter.setPassword(newPassword);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
	  }
	}

	@Override
	public void deleteAccount() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Voter voter = em.find(Voter.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(voter);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public List<Object[]> getCustomerList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
