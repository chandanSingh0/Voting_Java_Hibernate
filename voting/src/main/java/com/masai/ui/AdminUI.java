package com.masai.ui;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.CandidateDAO;
import com.masai.dao.CandidateDAOImpl;
import com.masai.entity.Candidate;
import com.masai.entity.Election;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.CandidateService;
import com.masai.service.CandidateServiceImpl;
import com.masai.service.ElectionService;
import com.masai.service.ElectionServiceImpl;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NoResultException;

public class AdminUI {
	static void addCandidate(Scanner sc) {
		//code to take company details input
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter candidate name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter party affiliation: ");
	        String partyAffiliation = scanner.nextLine();

	        // Create Candidate object using user input
	        Candidate candidate = new Candidate(name, partyAffiliation,null,null);
		
		//Create an object of Service Layer here
		CandidateService candidateService = new CandidateServiceImpl();
		try {
			candidateService.addCandidate(candidate);
			System.out.println("Company added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void viewCandidate() throws NoRecordFoundException {
		//Create an object of Service Layer here
		CandidateDAO cand = new CandidateDAOImpl();
		try {
			List<Candidate> candList = cand.getCandidateList();
			candList.forEach(person-> System.out.println("Id: "+ person.getId()+ " Candiddate Name:" 
					+ person.getName()+" Candidate PartyAffiliation Name:" 
							+ person.getPartyAffiliation()));
		}catch(SomethingWentWrongException | NoResultException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void updateCandidateDetails(Scanner sc) {
		//code to take company details input
		System.out.print("Enter id ");
		Long id = sc.nextLong();
		
		System.out.print("Enter candidate name ");
		String candidateName = sc.next();
		
		System.out.print("Enter PartyAffiliation ");
		String PartyAffiliationName = sc.next();
		
		//code to create Company Entity object
		Candidate candidate = new Candidate(candidateName, PartyAffiliationName, null, null);
		candidate.setId(id);
		
		//Create an object of Service Layer here
		CandidateDAO candService = new CandidateDAOImpl();
		try {
			candService.updateCandidate(candidate);;
			System.out.println("Company updated successfully");
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void addElection(Scanner sc) {
		
		try {
			System.out.print("Enter Election title");
			String planName = sc.next();
			System.out.print("Enter Description of the Election");
			String planType = sc.next();
			sc.nextLine();
			
			System.out.print("Enter Start Date (yyyy-MM-dd): ");
	        String startDateStr = sc.nextLine();
	        Date startDate = Date.valueOf(startDateStr);

	        System.out.print("Enter End Date (yyyy-MM-dd): ");
	        String endDateStr = sc.nextLine();
	        Date endDate = Date.valueOf(endDateStr);
			
			System.out.print("Enter Status of Election");
			System.out.println("1. Ongoing");
			System.out.println("2. Upcoming");
			System.out.println("3. Completed");
			Scanner sc1 = new Scanner(System.in);
			int val = sc1.nextInt();
			String status;
			if(val==1) {
			 status = "Ongoing";
			}else if(val==2) {
			 status = "Upcoming";
			}else {
		 status = "Completed";
			}
			//Create an object of Service Layer here
			ElectionService elecService = new ElectionServiceImpl();
			
			Election elect = new Election(planName,planType,startDate,endDate,status,null,null);		
			
			elecService.addElection(elect);;
			System.out.println("Plan added successfully");
		}catch(SomethingWentWrongException  ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void viewElections() {
		ElectionService ElecService = new ElectionServiceImpl();
		try {
			List<Object[]> ElecList = ElecService.getAllElections();
			for(Object[] plan: ElecList) {
//				System.out.println(plan);
				
				String title = (String) plan[0];
			    String description = (String) plan[1];
			    Date startDate = (Date) plan[2];
			    Date endDate = (Date) plan[3];
			    String status = (String) plan[4];

			    // Check if the candidate_id is null before accessing the candidate details
			    Candidate candidate = null;
			    if (plan[5] != null) {
			        Long candidateId = (Long) plan[5];
			        CandidateService candSer = new CandidateServiceImpl();
			        
			        candidate = candSer.getCandidateObjectByName(candidateId);
			    }
			    String candidateName = candidate.getName();
//			    String candidateAge = candidate.getName();
			    String candidateParty = candidate.getPartyAffiliation();
			    
			    System.out.println("Election Tiltle: "+ title + "\n" +"Election Description: "+ description + "\n"+"Election Start Date: " + startDate + "\n" +"Election End Date: "+ endDate + "\n" +"Election Status: "+ status +
			                       "\n" +"Election Candidate: " +candidateName +  "\n" +"Election PartyAffiliation: "+ candidateParty);
				
				
//				for (Object element : plan) {
//			        System.out.print(element + " ");
//			    }
//			    System.out.println();
			    
			    
			    
			    
//				System.out.println("Plan Id: " + plan[5] + ", Plan Name: " + plan[0] + ", Plan Type: " 
//						+ plan[1] + "GST Rate: " + plan[2] + ", Max Coverage Age: " + plan[3]
//						 + " Company Name: " + plan[4]);
//				AgeBandWisePremiumSurchargeForPlanService ab = new AgeBandWisePremiumSurchargeForPlanServiceImpl();
//				List<Object[]> premiumList = ab.getPremiumSurchargeForPlan((String)plan[0]);
//				for(Object[] premium: premiumList) {
//					System.out.println("For age " + premium[0] + "-" + premium[1] + " Premium: " + premium[2] + " Surcharge: " + premium[3]);
//				}
//				System.out.println();
			}
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void updateElection(Scanner sc) {
		//change: planName, planType, gstRate, maxCoverageAge, Company
		//code to take company details input
		try {
			System.out.print("Enter Election title");
			String planName = sc.next();
			System.out.print("Enter Description of the Election");
			String planType = sc.next();
			sc.nextLine();
			
			System.out.print("Enter Start Date (yyyy-MM-dd): ");
	        String startDateStr = sc.nextLine();
	        Date startDate = Date.valueOf(startDateStr);

	        System.out.print("Enter End Date (yyyy-MM-dd): ");
	        String endDateStr = sc.nextLine();
	        Date endDate = Date.valueOf(endDateStr);
			
			System.out.print("Enter Status of Election");
			System.out.println("1. Ongoing");
			System.out.println("2. Upcoming");
			System.out.println("3. Completed");
			Scanner sc1 = new Scanner(System.in);
			int val = sc1.nextInt();
			String status;
			if(val==1) {
			 status = "Ongoing";
			}else if(val==2) {
			 status = "Upcoming";
			}else {
		 status = "Completed";
			}
			//Create an object of Service Layer here
			ElectionService elecService = new ElectionServiceImpl();
			
			Election elect = new Election(planName,planType,startDate,endDate,status,null,null);		
			
			elecService.addElection(elect);;
			System.out.println("Plan Updated successfully");
		}catch(SomethingWentWrongException  ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
