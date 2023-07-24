package com.masai.service;

import java.util.List;

import com.masai.dao.VoterDAO;
import com.masai.dao.VoterDAOImpl;
import com.masai.entity.Voter;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class VoterServiceImpl implements VoterService {

	@Override
	public void addVoter(Voter voter) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		VoterDAO voterDAO = new VoterDAOImpl();
		voterDAO.addVoter(voter);
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		VoterDAO voterDAO = new VoterDAOImpl();
		voterDAO.login(username,password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		VoterDAO voterDAO = new VoterDAOImpl();
		voterDAO.changePassword(oldPassword,newPassword);
	
	}

	@Override
	public void deleteAccount() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		VoterDAO voterDAO = new VoterDAOImpl();
		voterDAO.deleteAccount();
	
	}

	@Override
	public List<Object[]> getCustomerList() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
