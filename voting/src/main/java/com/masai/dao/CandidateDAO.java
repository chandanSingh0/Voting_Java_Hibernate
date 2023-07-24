package com.masai.dao;

import java.util.List;

import com.masai.entity.Candidate;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CandidateDAO {
	void addCandidate(Candidate candidate) throws SomethingWentWrongException;
	List<Candidate> getCandidateList() throws SomethingWentWrongException, NoRecordFoundException;
	void updateCandidate(Candidate candidate) throws SomethingWentWrongException, NoRecordFoundException;
	Candidate getCandidateObjectByName(Long id) throws SomethingWentWrongException, NoRecordFoundException;
}

