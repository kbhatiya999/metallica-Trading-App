package com.tango.metallica.trade.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tango.metallica.trade.enitity.Trade;
import com.tango.metallica.trade.repo.TradeRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class TradeRestController
{

	@Autowired
	TradeRepo tradeRepo;
	
	@RequestMapping(path="/trade/{id}", method=RequestMethod.GET)
	public ResponseEntity<Trade> findTrade(@PathVariable("id") int id){
		
		ResponseEntity<Trade> re = null;
		
		System.out.println("FInd Trade in controller ..." + id);
		Trade t = tradeRepo.findTradeByTradeId(id);
		if(t == null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(t, HttpStatus.OK);
		}
		
		System.out.println(t);
		
		return re;

	}
		
	@RequestMapping(path="/trades", method=RequestMethod.GET)
	public List<Trade> findAllTrade(){
		return tradeRepo.findAll();
	}
	
	@RequestMapping(path="/trade", method=RequestMethod.POST)
	public ResponseEntity<Void> addTrade(@RequestBody Trade trade){
		ResponseEntity<Void> re = null;
	
			Trade t = tradeRepo.findTradeByCommodity(trade.getCommodity());
			System.out.println(t);
			
			if(t == null){
				tradeRepo.save(trade);
				re = new ResponseEntity<>(HttpStatus.CREATED);
			}
			else{
				re= new ResponseEntity<>(HttpStatus.CONFLICT);
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
	
	
		@RequestMapping(path="/trade/{tradeId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrade(@PathVariable("tradeId") int tradeId){
		tradeRepo.deleteById(tradeId);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
	
	



@RequestMapping(path="/trade" ,method=RequestMethod.PUT)
@Transactional
public ResponseEntity<Trade> updateTrade(@RequestBody Trade trade)
{
	ResponseEntity<Trade> re=null;
	try {
		Trade t=tradeRepo.getOne(trade.getTradeId());
		t.setPrice(trade.getPrice());
		t.setQuantity(trade.getQuantity());
		
		re=new ResponseEntity<Trade>(t,HttpStatus.OK);
	} catch (EntityNotFoundException e) {
		re=new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	return re;
} 

}






































