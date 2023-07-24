package com.masai.service;

import java.util.List;

import com.masai.dao.CandidateDAO;
import com.masai.dao.CandidateDAOImpl;
import com.masai.entity.Candidate;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class CandidateServiceImpl implements CandidateService {

	@Override
	public void addCandidate(Candidate candidate) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		candidateDAO.addCandidate(candidate);;
	
	}

	@Override
	public List<Candidate> getCandidateList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		
		return candidateDAO.getCandidateList();
	
	}

	@Override
	public void updateCandidate(Candidate candidate) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
CandidateDAO candidateDAO = new CandidateDAOImpl();
		
		candidateDAO.updateCandidate(candidate);;
	}

	@Override
	public Candidate getCandidateObjectByName(Long id)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		CandidateDAO candidateDAO = new CandidateDAOImpl();
		return candidateDAO.getCandidateObjectByName(id);

	}

}
