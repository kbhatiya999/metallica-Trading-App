package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tango.metallica.trade.enitity.UserRoleMap;

public interface UserRoleMapRepo extends JpaRepository<UserRoleMap, Integer> {

}
