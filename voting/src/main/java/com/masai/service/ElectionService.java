package com.masai.service;

import java.util.List;

import com.masai.entity.Election;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface ElectionService {
	void addElection(Election election) throws SomethingWentWrongException;
	List<Object[]> getAllElections() throws SomethingWentWrongException, NoRecordFoundException;
	void updateElection(Election election) throws SomethingWentWrongException, NoRecordFoundException;
	
}
