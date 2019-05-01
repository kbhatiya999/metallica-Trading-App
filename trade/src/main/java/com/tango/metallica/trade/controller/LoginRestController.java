package com.tango.metallica.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tango.metallica.trade.enitity.Trade;
import com.tango.metallica.trade.repo.LoginRepo;
import com.tango.metallica.trade.repo.UserDetailsRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api/")
public class LoginRestController {
	
	@Autowired
	LoginRepo loginRepo;
	
		
	

}
