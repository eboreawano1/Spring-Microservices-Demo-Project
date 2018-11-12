package com.ebore.bank.entities;

public class Employee {

	private String employeeFirstName;
	private String employeeMiddleName;
	private String employeeLastName;
	private long employeeId;
	private String employeeRole;
	private Address address;
	
	public Employee() {
		super();
	}

	public Employee(String employeeFirstName, String employeeMiddleName, String employeeLastName, long employeeId,
		String employeeRole, Address address) {
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

