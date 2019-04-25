package com.tango.metallica.trade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tango.metallica.trade.enitity.Transaction;
import com.tango.metallica.trade.repo.TransactionRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class TransactionRestController {
	@Autowired
	TransactionRepo transactionRepo;
	
	
		@RequestMapping(path="/transactions", method=RequestMethod.GET)
	public List<Transaction> findAllTransactions(){
		return transactionRepo.findAll();
	}
		
		
	 @RequestMapping(path="/transaction", method=RequestMethod.POST)
	public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction){
		ResponseEntity<Void> re = null;
	
			Transaction t = transactionRepo.findTransactionByTransactionId(transaction.getTransactionId());
			System.out.println(t);
			
			if(t == null){
				transactionRepo.save(transaction);
				re = new ResponseEntity<>(HttpStatus.CREATED);
			}
			else{
				re= new ResponseEntity<>(HttpStatus.CONFLICT);
			}

	return re;	
	}
	 
	 
/* Delete Method
 * 		@RequestMapping(path="/transaction/{transactionId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTransaction(@PathVariable("transactionId") int transactionId){
		transactionRepo.deleteById(transactionId);
		return new ResponseEntity<>(HttpStatus.OK);
	} */
	
	
}
