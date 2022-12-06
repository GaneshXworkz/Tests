package com.xworkz.atmapp.interfaced;

import java.util.HashMap;
import java.util.Map;

import com.xworkz.atmapp.atm.Atm;

public class AtmOperationImpl extends AtmOperation{

	
	Atm atm = new Atm();
	Map<Double,String> ministmt = new  HashMap<>();
	
	@Override
	public void viewBalance() {
		System.out.println("Available balance is : " + atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if(withdrawAmount <= atm.getBalance()) {
			ministmt.put(withdrawAmount, " Amount Withdrawn");
			System.out.println(" Coleect the cash " + withdrawAmount);
			atm.setBalance(atm.getBalance()- withdrawAmount);
			viewBalance();
		}
		else {
			System.out.println("Insufficient fund");
		}
		
	}

	@Override
	public void depositAmount(double depositAmount) {
		ministmt.put(depositAmount, " Amount Deposited");
		System.out.println(depositAmount + " Deposited Successfully");
		atm.setBalance(atm.getBalance()+depositAmount);
		viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for(Map.Entry<Double, String> m:ministmt.entrySet()) {
			System.out.println(m.getKey()+ " " + m.getValue());
		}
		
	}

	
}
