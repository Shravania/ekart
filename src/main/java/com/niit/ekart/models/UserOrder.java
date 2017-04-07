package com.niit.ekart.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class UserOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userOrderId;
	@OneToOne
	@JoinColumn(name="cartid")
private Cart cart;
	@OneToOne
	@JoinColumn(name="user_id")
private User user;
	public int getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@OneToOne
	@JoinColumn(name="billingAddress_Id")
private BillingAddress billingAddress;
	@OneToOne
	@JoinColumn(name="shippingAddress_Id")
private ShippingAddress shippingAddress;
}
