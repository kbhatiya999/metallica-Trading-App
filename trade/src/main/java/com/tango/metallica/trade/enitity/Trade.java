package com.tango.metallica.trade.enitity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Trade {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tradeId;
	
	private int traderId;
	private int quantity;
	private int price;
	private int commodityid;
	private Date dateOfOpenning;
	
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public int getTraderId() {
		return traderId;
	}
	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCommodityid() {
		return commodityid;
	}
	public void setCommodityid(int commodityid) {
		this.commodityid = commodityid;
	}
	public Date getDateOfOpenning() {
		return dateOfOpenning;
	}
	public void setDateOfOpenning(Date dateOfOpenning) {
		this.dateOfOpenning = dateOfOpenning;
	}
	
	
}
