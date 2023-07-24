package com.masai.dao;

import java.util.List;

import com.masai.entity.Voter;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface VoterDAO {
	void addVoter(Voter voter) throws SomethingWentWrongException;
	void login(String username, String password) 
			throws SomethingWentWrongException, NoRecordFoundException;
	void changePassword(String oldPassword, String newPassword) throws SomethingWentWrongException;
	void deleteAccount() throws SomethingWentWrongException;
	List<Object[]> getCustomerList() throws SomethingWentWrongException, NoRecordFoundException;

}
