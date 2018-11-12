package com.ebore.bank.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebore.bank.entities.Address;
import com.ebore.bank.entities.Bank;
import com.ebore.bank.entities.BankDetails;
import com.ebore.bank.entities.Employee;

@RestController
public class EmployeeController {
	
	@Value("${name.option}")
	private int nameOption;
	
	@Value("${address.option}")
	private String addressOption;
	
	@PostMapping("/process")
	public ResponseEntity<HashMap> process(@RequestBody BankDetails bankDetails) {	
		Employee employee = bankDetails.getEmployee();
		Bank bank = bankDetails.getBank();
		Address address = employee.getAddress();
		
		HashMap<String,HashMap<String,String>> result = new HashMap<>();
		HashMap<String,String> subResult = new HashMap();
		result.put("result", subResult);
		
		if (nameOption == 1) {
			subResult.put("employeeName", employee.getEmployeeFirstName() + " " + employee.getEmployeeMiddleName() + " " + employee.getEmployeeLastName());
		} else if (nameOption == 2) {
			subResult.put("employeeName", employee.getEmployeeLastName() + " " + employee.getEmployeeFirstName() + " " + employee.getEmployeeMiddleName());
		}
		
		if (addressOption.equals("full")) {
			subResult.put("address",address.getAddressLine1() + " " + address.getAddressLine2() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
		} else if (addressOption.equals("partial")){
			subResult.put("address",address.getAddressLine1() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
		}
		
	    return new ResponseEntity(result,HttpStatus.OK);
	}
}
