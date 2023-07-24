package com.masai.dao;

import java.util.List;
import java.util.Scanner;

import com.masai.entity.Candidate;
import com.masai.entity.Election;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ElectiionDAOImpl implements ElectionDAO {

	@Override
	public void addElection(Election election) throws SomethingWentWrongException {
		// TODO Auto-generated method stub

           EntityManager em = null;
		
		try {
			em = EMUtils.getEntityManager();
			
			//check if plan with same name exists
			Query query = em.createQuery("SELECT count(e) FROM Election e WHERE title = :etitle");
			query.setParameter("etitle", election.getTitle());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("Plan already exists with name " + election.getTitle());
			}
			
			//take age band object
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id of Candidate");
			long id = sc.nextLong();
		 query = em.createQuery("SELECT c FROM Candidate c WHERE c.id = :candidateId");
		    query.setParameter("candidateId", id);

		    Candidate candidate = (Candidate) query.getSingleResult();
			
			election.setCandidate(candidate);
			
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(election);
			et.commit();
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}

	@Override
	public List<Object[]> getAllElections() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		List<Object[]> ElectionList = null;
		try {
			em = EMUtils.getEntityManager();
//			Query query = em.createQuery("SELECT e.title, e.description, e.startDate, e.endDate, e.status FROM Election e JOIN Candidate c ON e.candidate = c");
			Query query = em.createQuery("SELECT e.title, e.description, e.startDate, e.endDate, e.status, c.id, c.name, c.partyAffiliation FROM Election e JOIN e.candidate c");
				
					
			
			ElectionList = (List<Object[]>)query.getResultList();
			if(ElectionList.size() == 0) {
				throw new NoRecordFoundException("No plan Found");
			}
		}catch(IllegalArgumentException ex) {
			ex.printStackTrace();	//this is only for debugging, please comment in production mode
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return ElectionList;
		
//		return null;
	}

	@Override
	public void updateElection(Election election) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			//check if plan with given id exists
			Election electFromDB = em.find(Election.class, election.getId());
			if(electFromDB == null)
				throw new NoRecordFoundException("No plan found with the given id " + election.getId());

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id of Candidate");
			long id = sc.nextLong();
		Query query = em.createQuery("SELECT c FROM Candidate c WHERE c.id = :candidateId");
		    query.setParameter("candidateId", id);

		    Candidate candidate = (Candidate) query.getSingleResult();
			
		    electFromDB.setCandidate(candidate);
			
			//proceed for update operation
			EntityTransaction et = em.getTransaction();
			et.begin();
			electFromDB.setTitle(election.getTitle());
			electFromDB.setDescription(election.getDescription());
			electFromDB.setStartDate(election.getStartDate());
			electFromDB.setEndDate(election.getEndDate());
			electFromDB.setStatus(election.getStatus());
			et.commit();
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}

	}

}
