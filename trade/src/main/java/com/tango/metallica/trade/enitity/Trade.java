package com.tango.metallica.trade.enitity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Trade {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tradeId;
	
	private int traderId;
	private int quantity;
	private int price;
	private int commodityid;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfOpening;
	
	
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
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	public Trade(int traderId, int quantity, int price, int commodityid, Date dateOfOpening) {
		super();
		this.traderId = traderId;
		this.quantity = quantity;
		this.price = price;
		this.commodityid = commodityid;
		this.dateOfOpening = dateOfOpening;
	}
	public Trade() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [tradeId=");
		builder.append(tradeId);
		builder.append(", traderId=");
		builder.append(traderId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", commodityid=");
		builder.append(commodityid);
		builder.append(", dateOfOpening=");
		builder.append(dateOfOpening);
		builder.append("]");
		return builder.toString();
	}
	
	
}
