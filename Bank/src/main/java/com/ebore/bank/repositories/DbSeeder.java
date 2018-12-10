package com.ebore.bank.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ebore.bank.entities.Bank;

@Component
public class DbSeeder implements CommandLineRunner {
    private BankRepository bankRepository;

    public DbSeeder(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Bank bank1 = new Bank();
        bank1.setAccountActive(true);
        bank1.setAccountNumber(1);
        bank1.setBankName("bankABC");
        bank1.setCardNumber(0000000000000001);


        Bank bank2 = new Bank();
        bank2.setAccountActive(true);
        bank2.setAccountNumber(2);
        bank2.setBankName("bank123");
        bank2.setCardNumber(0000000000000002);

        Bank bank3 = new Bank();
        bank3.setAccountActive(true);
        bank3.setAccountNumber(3);
        bank3.setBankName("bankxyz");
        bank3.setCardNumber(0000000000000003);
        

        // drop all hotels
        this.bankRepository.deleteAll();

        //add our hotels to the database
        List<Bank> banks = Arrays.asList(bank1, bank2, bank3);
        this.bankRepository.saveAll(banks);
    }
}