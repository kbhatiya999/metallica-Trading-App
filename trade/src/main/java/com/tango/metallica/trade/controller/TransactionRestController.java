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

import com.tango.metallica.trade.enitity.Inventory;
import com.tango.metallica.trade.enitity.Trade;
import com.tango.metallica.trade.enitity.Transaction;
import com.tango.metallica.trade.enitity.UserDetails;
import com.tango.metallica.trade.repo.InventoryRepo;
import com.tango.metallica.trade.repo.TradeRepo;
import com.tango.metallica.trade.repo.TransactionRepo;
import com.tango.metallica.trade.repo.UserDetailsRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class TransactionRestController {
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	TradeRepo tradeRepo;
	@Autowired
	UserDetailsRepo userDetailsRepo;
	@Autowired
	InventoryRepo inventoryRepo;
	
		@RequestMapping(path="/transactions", method=RequestMethod.GET)
	public List<Transaction> findAllTransactions(){
		return transactionRepo.findAll();
	}
		
		
	 @RequestMapping(path="/transaction", method=RequestMethod.POST)
	public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction){
		ResponseEntity<Void> re = null;
	System.out.println(transaction);
				Trade trade = tradeRepo.getOne(transaction.getTrade().getTradeId());
				trade.setTradeStatus(1);
				tradeRepo.save(trade);
				
				//Sellerinventory
				UserDetails user=trade.getTrader();
				System.out.println(user);
		        List<Inventory>myInventories=inventoryRepo.findInventoryByDetails(user);
		        boolean flag=false;
		        Inventory old=new Inventory();
		        for(Inventory i:myInventories)
		        {
		        	if((i.getCommodity().getCommodityId())==(trade.getCommodity().getCommodityId()))
		        	{
		        		flag=true;
		        		old=i;
		        		break;
		        	}
		        }
		        	Inventory i=inventoryRepo.getOne(old.getInventoryId());
		        	i.setQuantity(i.getQuantity()-trade.getQuantity());
		        	//re = new ResponseEntity<>(HttpStatus.CREATED);
		        
				
		      //Buyerinventoryclose
				
		        //SellerInventor
		        	
		        UserDetails seller=userDetailsRepo.findUserDetailsByUserId(transaction.getTo().getUserId());
		        List<Inventory>sellerInventories=inventoryRepo.findInventoryByDetails(seller);
		        flag=false;
		        Inventory sellerold=new Inventory();
		        for(Inventory inventory:sellerInventories)
		        {
		        	if((inventory.getCommodity().getCommodityId())==(trade.getCommodity().getCommodityId()))
		        	{
		        		flag=true;
		        		sellerold=inventory;
		        		break;
		        	}
		        }
		        if(flag)
		        {
		        	Inventory inventory=inventoryRepo.getOne(sellerold.getInventoryId());
		        	inventory.setQuantity(inventory.getQuantity()+trade.getQuantity());
		        	//re = new ResponseEntity<>(HttpStatus.CREATED);
		        }
		        else
		        {
		        	Inventory newItem=new Inventory();
		        	newItem.setCommodity(trade.getCommodity());
		        	newItem.setDetails(transaction.getTo());
		        	newItem.setQuantity(trade.getQuantity());
		        	inventoryRepo.save(newItem);
		        	//re = new ResponseEntity<>(HttpStatus.CREATED);
		        }
		        
		        //SellerInventoryClose
		        
				transactionRepo.save(transaction);
				re = new ResponseEntity<>(HttpStatus.CREATED);
		System.out.println(transaction);
	return re;	
	}
	 
	 
/* Delete Method
 * 		@RequestMapping(path="/transaction/{transactionId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTransaction(@PathVariable("transactionId") int transactionId){
		transactionRepo.deleteById(transactionId);
		return new ResponseEntity<>(HttpStatus.OK);
	} */
	
	
}
