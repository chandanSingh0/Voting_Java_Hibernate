package com.masai.ui;

import java.util.Scanner;

import com.masai.exception.NoRecordFoundException;

public class App {
    
	static void adminMenu(Scanner sc) throws NoRecordFoundException {
		int choice = 0;
		do {
			System.out.println("1. Add Candidate");
			System.out.println("2. View All Candidates");
			System.out.println("3. Update Candidate Details");
			System.out.println("4. Add Elections");
			System.out.println("5. View All Elections");
		   System.out.println("6. Update Elections");
//			System.out.println("7. Update premium for an age band of a plan");
//			System.out.println("8. See List of all Customers");
//			System.out.println("9. See policy reports");
//			System.out.println("10. Make Policies Discountinued");
			System.out.println("0. Logout");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				AdminUI.addCandidate(sc);
    				break;
    			case 2:
    				AdminUI.viewCandidate();
    				break;
    			case 3:
    				AdminUI.updateCandidateDetails(sc);
    				break;
    			case 4:
    				AdminUI.addElection(sc);
    				break;
    			case 5:
    				AdminUI.viewElections();
    				break;
    			case 6:
    				AdminUI.updateElection(sc);
    				break;
    			case 0:
    				System.out.println("wishing you a happy day");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	static void adminLogin(Scanner sc) throws NoRecordFoundException {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
	public static void main( String[] args ) throws NoRecordFoundException{
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Voter Login");
    		System.out.println("3. Voter Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				adminLogin(sc);
    				break;
    			case 2:
    				VoterUI.userLogin(sc);
    				break;
    			case 3:
    			VoterUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
	}
}
	
