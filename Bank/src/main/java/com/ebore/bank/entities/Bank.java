package com.ebore.bank.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bank {

	@JsonProperty("bankName") private String bankName;
	@JsonProperty("accountNumber") private long accountNumber;
	@JsonProperty("cardNumber") private long cardNumber;
	@JsonProperty("accountActive") private boolean accountActive;
	
	@JsonCreator
	public Bank(@JsonProperty("bankName") String bankName, @JsonProperty("accountNumber") long accountNumber, @JsonProperty("cardNumber")  long cardNumber,@JsonProperty("accountActive") boolean accountActive) {
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
}
