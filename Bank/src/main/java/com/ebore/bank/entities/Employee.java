package com.ebore.bank.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("employeeFirstName") private String employeeFirstName;
	@JsonProperty("employeeMiddleName") private String employeeMiddleName;
	@JsonProperty("employeeLastName") private String employeeLastName;
	@JsonProperty("employeeId") private long employeeId;
	@JsonProperty("employeeRole") private String employeeRole;
	@JsonProperty("address") private Address address;
	
	@JsonCreator
	public Employee(@JsonProperty("employeeFirstName") String employeeFirstName, @JsonProperty("employeeMiddleName") String employeeMiddleName, @JsonProperty("employeeLastName") String employeeLastName, @JsonProperty("employeeId") long employeeId,
			@JsonProperty("employeeRole") String employeeRole, @JsonProperty("address") Address address) {
		super();
		this.employeeFirstName = employeeFirstName;
		this.employeeMiddleName = employeeMiddleName;
		this.employeeLastName = employeeLastName;
		this.employeeId = employeeId;
		this.employeeRole = employeeRole;
		this.address = address;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeMiddleName() {
		return employeeMiddleName;
	}

	public void setEmployeeMiddleName(String employeeMiddleName) {
		this.employeeMiddleName = employeeMiddleName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [employeeFirstName=" + employeeFirstName + ", employeeMiddleName=" + employeeMiddleName
				+ ", employeeLastName=" + employeeLastName + ", employeeId=" + employeeId + ", employeeRole="
				+ employeeRole + ", address=" + address + "]";
	}
}
