package com.tango.metallica.trade.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.tango.metallica.trade.enitity.Commodity;
import com.tango.metallica.trade.enitity.Location;
import com.tango.metallica.trade.enitity.Trade;
import com.tango.metallica.trade.repo.CommodityRepo;
import com.tango.metallica.trade.repo.LocationRepo;
import com.tango.metallica.trade.repo.TradeRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class LocationRestController
{

	@Autowired
	LocationRepo locationRepo;
	
	@RequestMapping(path="/location/{id}", method=RequestMethod.GET)
	public ResponseEntity<Location> findLocation(@PathVariable("id") int id){
		
		ResponseEntity<Location> re = null;
		
		System.out.println("FInd Location in controller ..." + id);
		Location t = locationRepo.findLocationByLocationId(id);
		if(t == null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(t, HttpStatus.OK);
		}
		
		System.out.println(t);
		
		return re;

	}
		
	@RequestMapping(path="/locations", method=RequestMethod.GET)
	public List<Location> findAllLocations(){
		List<Location> result = locationRepo.findAll();
//		result.stream().filter(t->((Integer)t.getTradeStatus()).equals(1)).collect(Collectors.toList());
		return result;
	}
	
	@RequestMapping(path="/location", method=RequestMethod.POST)
	public ResponseEntity<Void> addLocation(@RequestBody Location location){
		ResponseEntity<Void> re = null;
		
				locationRepo.save(location);
				re = new ResponseEntity<>(HttpStatus.CREATED);
			

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
	
	
		@RequestMapping(path="/location/{locationId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLocation(@PathVariable("locationId") int locationId){
		locationRepo.deleteById(locationId);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
	
	





}






































