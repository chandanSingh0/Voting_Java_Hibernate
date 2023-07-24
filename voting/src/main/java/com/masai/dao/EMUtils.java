package com.masai.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("project_voting");
	}
	
	static EntityManager getEntityManager() {
		 return emf.createEntityManager();
	}
	public static void main(String[] args) {
		System.out.println(getEntityManager());
		
	}
}
