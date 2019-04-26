package com.tango.metallica.trade.enitity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Trade {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tradeId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="userId")
	private UserDetails trader;
	private int quantity;
	private int price;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="commodityId")
	private Commodity commodity;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfOpening;
	
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public UserDetails getTrader() {
		return trader;
	}
	public void setTraderId(UserDetails traderId) {
		this.trader = traderId;
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
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodityid) {
		this.commodity = commodityid;
	}
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	public Trade(UserDetails traderId, int quantity, int price, Commodity commodityid, Date dateOfOpening) {
		super();
		this.trader = traderId;
		this.quantity = quantity;
		this.price = price;
		this.commodity = commodityid;
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
		builder.append(trader);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", commodityid=");
		builder.append(commodity);
		builder.append(", dateOfOpening=");
		builder.append(dateOfOpening);
		builder.append("]");
		return builder.toString();
	}
	
	
}
