package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer>{
    UserDetails findUserDetailsByUserId(int id);
}
