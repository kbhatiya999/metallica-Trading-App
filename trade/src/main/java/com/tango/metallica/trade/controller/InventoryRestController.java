package com.tango.metallica.trade.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tango.metallica.notifications.SendInventoryMsgs;
import com.tango.metallica.trade.enitity.Inventory;
import com.tango.metallica.trade.enitity.Trade;
import com.tango.metallica.trade.enitity.UserDetails;
import com.tango.metallica.trade.repo.InventoryRepo;
import com.tango.metallica.trade.repo.UserDetailsRepo;

@RestController
@Transactional
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class InventoryRestController {

	@Autowired
	InventoryRepo inventoryRepo;
	@Autowired
	UserDetailsRepo userDetailsRepo;
	SendInventoryMsgs sim = new SendInventoryMsgs();	
	@RequestMapping(path="/allinventory", method=RequestMethod.GET)
	public List<Inventory> findAllInventory(){
		List<Inventory> result = inventoryRepo.findAll();
		return result;
	}
	
	@RequestMapping(path="/inventory", method=RequestMethod.POST)
	public ResponseEntity<Void> addInventory(@RequestBody Inventory inventory){
		ResponseEntity<Void> re = null;
	
		        UserDetails user=userDetailsRepo.findUserDetailsByUserId(inventory.getDetails().getUserId());
		        List<Inventory>myInventories=inventoryRepo.findInventoryByDetails(user);
		        boolean flag=false;
		        Inventory old=new Inventory();
		        for(Inventory i:myInventories)
		        {
		        	if((i.getCommodity().getCommodityId())==(inventory.getCommodity().getCommodityId()))
		        	{
		        		flag=true;
		        		old=i;
		        		break;
		        	}
		        }
		        if(flag)
		        {
		        	Inventory i=inventoryRepo.getOne(old.getInventoryId());
		        	i.setQuantity(i.getQuantity()+inventory.getQuantity());
		        	re = new ResponseEntity<>(HttpStatus.CREATED);
		        	sim.sendCreateInventoryMessage(old.getInventoryId());
		        }
		        else
		        {
		        	inventoryRepo.save(inventory);
		        	re = new ResponseEntity<>(HttpStatus.CREATED);
		        	sim.sendCreateInventoryMessage(inventory.getInventoryId());
		        }
				

	return re;	
	}
	

//	@RequestMapping(path="/trade", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteTrade(@RequestParam("tradeId") int tradeId){
//		ResponseEntity<Void> re = null;
//	
//			Trade t = tradeRepo.findTradeById(tradeId);
//			System.out.println(t);
//			
//			if(t != null){
//				tradeRepo.deleteById(tradeId);
//				re = new ResponseEntity<>(HttpStatus.OK);
//			}
//			else{
//				re = new ResponseEntity<>(HttpStatus.CONFLICT);
//			}
//
//		return re;		
//	}
	
	
//		@RequestMapping(path="/trade/{tradeId}", method=RequestMethod.DELETE)
//	public ResponseEntity<Void> deleteTrade(@PathVariable("tradeId") int tradeId){
//		tradeRepo.deleteById(tradeId);
//		return new ResponseEntity<>(HttpStatus.OK);
//	} 
//	
	



//@RequestMapping(path="/trade" ,method=RequestMethod.PUT)
//@Transactional
//public ResponseEntity<Trade> updateTrade(@RequestBody Trade trade)
//{
//	ResponseEntity<Trade> re=null;
//	try {
//		Trade t=tradeRepo.getOne(trade.getTradeId());
//		t.setPrice(trade.getPrice());
//		t.setQuantity(trade.getQuantity());
//		
//		re=new ResponseEntity<Trade>(t,HttpStatus.OK);
//	} catch (EntityNotFoundException e) {
//		re=new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//	}
//	
//	return re;
//} 

}
