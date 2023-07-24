package com.masai.service;

import java.util.List;

import com.masai.dao.ElectiionDAOImpl;
import com.masai.dao.ElectionDAO;
import com.masai.entity.Election;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class ElectionServiceImpl implements ElectionService {

	@Override
	public void addElection(Election election) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		ElectionDAO elec = new ElectiionDAOImpl();
		elec.addElection(election);
	}

	@Override
	public List<Object[]> getAllElections() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		ElectionDAO elec = new ElectiionDAOImpl();
		return elec.getAllElections();
		
	}

	@Override
	public void updateElection(Election election) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		ElectionDAO elec = new ElectiionDAOImpl();
		elec.updateElection(election);
	}

}
