package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tango.metallica.trade.enitity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
