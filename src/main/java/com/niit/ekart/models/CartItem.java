package com.niit.ekart.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem {
	@EmbeddedId
	CartGroup cartGroupId;
	@NotNull
	private Integer quantity;
	@NotNull
	private String totalPrice;
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public CartGroup getCartGroupId() {
		return cartGroupId;
	}
	public void setCartGroupId(CartGroup cartGroupId) {
		this.cartGroupId = cartGroupId;
	}
	
	
}

