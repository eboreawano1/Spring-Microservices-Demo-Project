package com.ebore.bank.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Value("${recipient.option}")
	private String recipientOption;
	
	private static final String POST_URI = "/receive";
	private static final String FULL = "full";
	private static final String PARTIAL = "partial";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping("/process")
	public ResponseEntity<Object> process(@RequestBody BankDetails bankDetails) {	
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
		
		if (addressOption.equals(FULL)) {
			subResult.put("address",address.getAddressLine1() + " " + address.getAddressLine2() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
		} else if (addressOption.equals(PARTIAL)){
			subResult.put("address",address.getAddressLine1() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
		}
		
	    return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/send")
	public ResponseEntity<Object> testProcess(@RequestBody BankDetails bankDetails) {	
		List<ServiceInstance> instances = this.discoveryClient.getInstances(recipientOption);
		
		System.out.println("-------------------------------------");
		for (ServiceInstance instance: instances) {
			System.out.println(instance.getHost() + " " + instance.getPort() + " " + instance.getUri() + " " + instance.getServiceId());
		}
		System.out.println("-------------------------------------");
		
		Random random = new Random();
		int i = random.nextInt(instances.size());
		
		String bankURI = instances.get(i).getUri().toString();
		System.out.println();
		System.out.println(instances.get(i).getHost() + " " + instances.get(i).getPort() + " " + instances.get(i).getUri() + " " + instances.get(i).getServiceId());
		
		Employee employee = bankDetails.getEmployee();
		Bank bank = bankDetails.getBank();
		Address address = employee.getAddress();
		
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("employeeName", employee);
		uriVariables.put("address", address);
		
		ResponseEntity<Response> responseEntity = restTemplate
				.postForEntity(bankURI + POST_URI, employee, Response.class);
		
		Response response = responseEntity.getBody();
		
		HashMap<String,Response> result = new HashMap<>();
		result.put("result", response);
		
	    return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@PostMapping("/time")
	public void process() {	
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
