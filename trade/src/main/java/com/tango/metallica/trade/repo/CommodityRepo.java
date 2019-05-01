package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.Commodity;



public interface CommodityRepo extends JpaRepository<Commodity, Integer> {

	public Commodity findCommodityByCommodityId(int id);
	
}
