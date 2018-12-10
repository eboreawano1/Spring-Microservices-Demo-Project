package com.ebore.bank.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bank")
public class Bank {

	@Id
	private ObjectId id;
	private String bankName;
	private long accountNumber;
	private long cardNumber;
	private boolean accountActive;
	
	public Bank() {
		super();
	}

	public Bank(String bankName, long accountNumber, long cardNumber, boolean accountActive) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;
		this.accountActive = accountActive;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean isAccountActive() {
		return accountActive;
	}

	public void setAccountActive(boolean accountActive) {
		this.accountActive = accountActive;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", accountNumber=" + accountNumber + ", cardNumber=" + cardNumber
				+ ", accountActive=" + accountActive + "]";
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}
