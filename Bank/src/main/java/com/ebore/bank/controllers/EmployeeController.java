package com.ebore.bank.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ebore.bank.entities.Address;
import com.ebore.bank.entities.Bank;
import com.ebore.bank.entities.BankDetails;
import com.ebore.bank.entities.Employee;
import com.ebore.bank.entities.Response;

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
	
	@PostMapping("/send")
	public ResponseEntity<HashMap> testProcess(@RequestBody BankDetails bankDetails) {	
		Employee employee = bankDetails.getEmployee();
		Bank bank = bankDetails.getBank();
		Address address = employee.getAddress();
		
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("employeeName", employee);
		uriVariables.put("address", address);
		
		ResponseEntity<Response> responseEntity = new RestTemplate()
				.postForEntity("http://localhost:8000/receive", employee, Response.class);
		
		Response response = responseEntity.getBody();
		
		HashMap<String,Response> result = new HashMap<>();
		result.put("result", response);
		
		
	    return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
