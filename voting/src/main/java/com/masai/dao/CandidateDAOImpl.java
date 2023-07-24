package com.masai.dao;

import java.util.List;

import com.masai.entity.Candidate;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CandidateDAOImpl implements CandidateDAO {

	@Override
	public void addCandidate(Candidate candidate) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if company with same name exists
			Query query = em.createQuery("SELECT count(c) FROM Candidate c WHERE id = :candidateId");
			query.setParameter("candidateId", candidate.getId());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomethingWentWrongException("Company already exists with name " + candidate.getName());
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(candidate);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			if (em != null) {
		        em.close();
		    }
		}
	}

	@Override
	public List<Candidate> getCandidateList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<Candidate> candidateList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Candidate c");
			candidateList = (List<Candidate>)query.getResultList();
			if(candidateList.size() ==0) {
				throw new NoRecordFoundException("No company Found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			
		        em.close();
		    
		}
		return candidateList;
	}

	@Override
	public void updateCandidate(Candidate candidate) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			//check if candidate with candidate with given id exists
			Candidate candidateFromDB = em.find(Candidate.class, candidate.getId());
			if(candidateFromDB == null)
				throw new NoRecordFoundException("No Company found with the given id " + candidate.getId());

			
			
			//proceed for update operation
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			candidateFromDB.setName(candidate.getName());
			candidateFromDB.setPartyAffiliation(candidate.getPartyAffiliation());
//			candidateFromDB.setSectorType(company.getSectorType());
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public Candidate getCandidateObjectByName(Long id)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<Candidate> candidateList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Candidate c WHERE id = :candidateId");
			query.setParameter("candidateId", id);
			//we cannot use getSingleResult here because if no company exists with the given name then it throws exception
			//so used getSingleResult if and only if you are sure that there will be result against your query
			candidateList = (List<Candidate>)query.getResultList();
			if(candidateList.size() ==0) {
				throw new NoRecordFoundException("No Candidate Found");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		return candidateList.get(0);
		
	}

}
