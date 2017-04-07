package com.niit.ekart.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Cart {
    @Id
	private Integer cartId;
    @NotNull
	@ManyToOne
	private User userId;
    @OneToMany(cascade=CascadeType.ALL)
    
	private Set<CartItem> cartItems = new HashSet<CartItem>(0);
    
    public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public User getUserId() {
		return userId ;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Set<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
