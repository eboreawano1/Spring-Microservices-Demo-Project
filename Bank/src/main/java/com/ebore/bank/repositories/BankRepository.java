package com.ebore.bank.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ebore.bank.entities.Bank;

@Repository
public interface BankRepository extends MongoRepository<Bank,String>{
	Bank findById(ObjectId id);
}
