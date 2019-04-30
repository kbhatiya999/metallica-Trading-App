package com.tango.metallica.trade.enitity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.NamedNativeQueries;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Commodity commodity; 
	private int quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private UserDetails details;

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	
	public Inventory(Commodity commodity, int quantity, UserDetails details) {
		super();
		this.commodity = commodity;
		this.quantity = quantity;
		this.details = details;
	}


	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [inventoryId=");
		builder.append(inventoryId);
		builder.append(", commodity=");
		builder.append(commodity);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", details=");
		builder.append(details);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
