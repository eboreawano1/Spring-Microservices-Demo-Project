package com.ebore.bank.entities;

public class BankDetails {
	private Employee employee;
	private Bank bank;
	
	public BankDetails() {
		super();
	}

	public BankDetails( Employee employee, Bank bank) {
		super();
		this.employee = employee;
		this.bank = bank;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "BankDetails [employee=" + employee + ", bank=" + bank + "]";
	}
}

