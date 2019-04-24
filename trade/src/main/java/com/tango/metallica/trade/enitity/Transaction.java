package com.tango.metallica.trade.enitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private int toId; 
	private int fromId;
	private int toLocationId;
	private int fromLocationId;
	private String password;
	private int roleId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getToLocationId() {
		return toLocationId;
	}
	public void setToLocationId(int toLocationId) {
		this.toLocationId = toLocationId;
	}
	public int getFromLocationId() {
		return fromLocationId;
	}
	public void setFromLocationId(int fromLocationId) {
		this.fromLocationId = fromLocationId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
