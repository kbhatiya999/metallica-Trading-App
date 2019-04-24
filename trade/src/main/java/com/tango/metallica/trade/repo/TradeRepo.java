package com.tango.metallica.trade.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tango.metallica.trade.enitity.Trade;

public interface TradeRepo extends JpaRepository<Trade, Integer>{

	
	public Trade findTradeBycommodityid( int commodityid);
	public Trade findTradeByTradeId( int tradeid);
	public void deleteByTradeId(int id);
}
