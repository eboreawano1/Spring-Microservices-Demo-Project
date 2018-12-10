package com.ebore.bank.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebore.bank.entities.Bank;
import com.ebore.bank.repositories.BankRepository;

@RestController
public class BankController {

	@Autowired
	BankRepository bankRepository;
	
	@GetMapping("/get")
	public List<Bank> getAllBanks() {
	  return bankRepository.findAll();
	}

	@GetMapping(value = "/get/{id}")
	public Bank getBankById(@PathVariable("id") ObjectId id) {
	  return bankRepository.findById(id);
	}
	
	@PutMapping(value = "/update/{id}")
	public void modifyBankById(@PathVariable("id") ObjectId id, @Valid @RequestBody Bank bank) {
	  bank.setId(id);
	  bankRepository.save(bank);
	}
	
	@PostMapping(value = "/create")
	public Bank createBank(@Valid @RequestBody Bank bank) {
	  bank.setId(ObjectId.get());
	  bankRepository.save(bank);
	  return bank;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteBank(@PathVariable ObjectId id) {
	  bankRepository.delete(bankRepository.findById(id));
	}
}
