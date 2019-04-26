package com.tango.metallica.trade.enitity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="tradeId")
	private Trade trade; 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="userId")
	private UserDetails from;
	//private int toLocationId;
	//private int fromLocationId;
	//private int quantity;
	//private int price;
	//private int commodityid;
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date dateOfOpening;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfPurchase;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Trade getTrade() {
		return trade;
	}
	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	public UserDetails getFrom() {
		return from;
	}
	public void setFrom(UserDetails from) {
		this.from = from;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Transaction() {
		super();
	}
	public Transaction(Trade trade, UserDetails from, Date dateOfPurchase) {
		super();
		this.trade = trade;
		this.from = from;
		this.dateOfPurchase = dateOfPurchase;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", trade=");
		builder.append(trade);
		builder.append(", from=");
		builder.append(from);
		builder.append(", dateOfPurchase=");
		builder.append(dateOfPurchase);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
