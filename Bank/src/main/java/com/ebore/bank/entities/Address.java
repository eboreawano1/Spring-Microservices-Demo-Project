package com.ebore.bank.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	@JsonProperty("addressLine1") private String addressLine1;
	@JsonProperty("addressLine2") private String addressLine2;
	@JsonProperty("city") private String city;
	@JsonProperty("state") private String state;
	@JsonProperty("zip") private String zip;
	
	@JsonCreator
	public Address(@JsonProperty("addressLine1") String addressLine1,@JsonProperty("addressLine2") String addressLine2, @JsonProperty("city") String city, @JsonProperty("state") String state, @JsonProperty("zip") String zip) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}
}
