package com.xworkz.atmapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.xworkz.atmapp.interfaced.AtmOperation;
import com.xworkz.atmapp.interfaced.AtmOperationImpl;

public class AtmTester {

	public static void main(String[] args) {
		
		AtmOperation op = new AtmOperationImpl();
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to SBI Atm ");
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "Xworkzodc@123");
			 
			java.sql.Statement stam=con.createStatement();
			

			System.out.print("Enter pin : ");
			int pin = in.nextInt();
			
			
			ResultSet rs=((java.sql.Statement) stam).executeQuery("select * from coustomer_detales where atm_pin= " + pin);
			
			while (rs.next())
				System.out.println(rs.getInt(1) + "\n" +rs.getString(2));
			
			con.close();
			
		//System.out.println("enter pin agin : ");
			//int n = in.nextInt();
			
			
			
			if((pin==pin)) {
				while(true) {
					System.out.println("1. View available balance \n 2. Withdraw amount \n 3. Deposit amount \n 4. Mini Statement \n 5. Exit");
					System.out.println("Enter Choice");
					int ch = in.nextInt();
					if(ch==1) {
						op.viewBalance();
					}
					else if(ch==2) {
						System.out.println("Enter Amount to Withdraw");
						double withdrawAmount = in.nextDouble();
						op.withdrawAmount(withdrawAmount);
					}
					else if(ch==3) {
						System.out.println("Enter Amount to Deposit : ");
						double depositAmount = in.nextDouble();
						op.depositAmount(depositAmount);
					}
					else if(ch==4) {
						op.viewMiniStatement();
					}
					else if(ch==5) {
						
						System.out.println("Collect your ATM card \n Thank you for using SBI Atm");
						System.exit(0);
					}
					else {
						System.out.println("Please enter your choice");
					}
				}
			}
			else {
				System.out.println("Incorrect atm pin");
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
