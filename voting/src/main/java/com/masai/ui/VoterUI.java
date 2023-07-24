package com.masai.ui;

import java.sql.Date;
import java.util.Scanner;

import com.masai.entity.LoggedInUserId;
import com.masai.entity.Voter;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;
import com.masai.service.VoterService;
import com.masai.service.VoterServiceImpl;

public class VoterUI {
	
	static void customerRegistration(Scanner sc) {
		//code to take input
		sc.nextLine();
		System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine().toString();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Postal Code: ");
        String postalCode = sc.nextLine();

        System.out.println("Enter Verification Status: ");
        
		System.out.println("1. Verified");
		System.out.println("2. Unverified");
		Scanner sc1 = new Scanner(System.in);
		int val = sc1.nextInt();
		String verificationStatus;
		if(val==1) {
			verificationStatus = "Ongoing";
		}else if(val==2) {
			verificationStatus = "Upcoming";
		}else {
			verificationStatus = "Completed";
		}
         

       
        

		System.out.print("Enter Last Login Timestamp (yyyy-MM-dd HH:mm:ss): ");
        String startDateStr = sc.nextLine();
        Date startDate = Date.valueOf(startDateStr);
       
		
		//Create an object of customer
		Voter voter = new Voter(name, email, password, address, city, state,postalCode,verificationStatus,startDate,null);
		
		try {
			//Create an object of CustomerService
			VoterService voterService = new VoterServiceImpl();
			voterService.addVoter(voter);
			System.out.println("Voter added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	static void Voter_Menu(Scanner sc) {
		int choice = 0;
		do {
			
			System.out.println("1. View All Elections");
			System.out.println("2. View All Candidates");
			System.out.println("3. Casting Votes");
			
			System.out.println("4. Change Password");
			System.out.println("5. Delete Account");
			System.out.println("0. Logout");
			
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//this code is same as we have used on the admin side
    				//so we are using here as it is
    				
    				AdminUI.viewElections();;
    				break;
    			case 2:System.out.println("hello");
//    				calculatePolicyPremium(sc);
    				break;
    			case 3:System.out.println("hello");
    				break;
    			case 4:changePassword(sc);
    				break;
    			case 5:deleteAccount(sc);
					choice = 0;
    			case 0:
    				LoggedInUserId.loggedInUserId = -1;	//-1 id cannot belong to any customer
    				System.out.println("Have A Good-Day");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
	}
	
	
	static void userLogin(Scanner sc) {
		System.out.print("Enter Your Name ");
		String username = sc.next();
		System.out.print("Enter Password ");
		String password = sc.next();
		try {
			VoterService voterService = new VoterServiceImpl();
			voterService.login(username, password);
			Voter_Menu(sc);
		}catch(NoRecordFoundException | SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void changePassword(Scanner sc) {
		System.out.print("Enter old password ");
		String oldPassword = sc.next();
		System.out.print("Enter new password ");
		String newPassword = sc.next();
		System.out.print("Re-Enter new password ");
		String reEnterNewPassword = sc.next();
		
		//Check if new password is correct
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println("New password and Re-Entered password mismtached");
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println("New password and old password must be different");
			return;
		}
		
		try {
			VoterService voterService = new VoterServiceImpl();
			voterService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println("Password updated");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void deleteAccount(Scanner sc) {
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				VoterService voterService = new VoterServiceImpl();
				voterService.deleteAccount();
				System.out.println("your registered account is deleted");			
			}catch(SomethingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
}
