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

import com.tango.metallica.trade.repo.CommodityRepo;


@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class CommodityRestController
{

	@Autowired
	CommodityRepo commodityRepo;
	
	@RequestMapping(path="/commodity/{id}", method=RequestMethod.GET)
	public ResponseEntity<Commodity> findCommodity(@PathVariable("id") int id){
		
		ResponseEntity<Commodity> re = null;
		
		System.out.println("FInd Commodity in controller ..." + id);
		Commodity t = commodityRepo.findCommodityByCommodityId(id);
		if(t == null){
			re = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		else{
			re = new ResponseEntity<>(t, HttpStatus.OK);
		}
		
		System.out.println(t);
		
		return re;

	}
		
	@RequestMapping(path="/commodities", method=RequestMethod.GET)
	public List<Commodity> findAllTrade(){
		List<Commodity> result = commodityRepo.findAll();
//		result.stream().filter(t->((Integer)t.getTradeStatus()).equals(1)).collect(Collectors.toList());
		return result;
	}
	
	@RequestMapping(path="/commodity", method=RequestMethod.POST)
	public ResponseEntity<Void> addCommodity(@RequestBody Commodity commodity){
		ResponseEntity<Void> re = null;
		
				commodityRepo.save(commodity);
				re = new ResponseEntity<>(HttpStatus.CREATED);
			

	return re;	
	}
	
	
	
		@RequestMapping(path="/commodity/{commodityId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCommodity(@PathVariable("commodityId") int commodityId){
		commodityRepo.deleteById(commodityId);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
	
	





}






































