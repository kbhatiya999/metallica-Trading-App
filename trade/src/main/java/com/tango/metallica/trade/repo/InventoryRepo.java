package com.tango.metallica.trade.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.Inventory;
import com.tango.metallica.trade.enitity.UserDetails;



public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
     List<Inventory>findInventoryByDetails(UserDetails user);
}
