package com.ebore.bank.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankDetails {
	@JsonProperty("employee") private Employee employee;
	@JsonProperty("bank") private Bank bank;
	
	@JsonCreator
	public BankDetails(@JsonProperty("employee") Employee employee, @JsonProperty("bank") Bank bank) {
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
