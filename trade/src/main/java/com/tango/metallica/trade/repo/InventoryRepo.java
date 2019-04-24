package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.Inventory;



public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

}
