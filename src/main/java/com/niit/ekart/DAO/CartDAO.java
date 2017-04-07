package com.niit.ekart.DAO;

import java.util.List;

import com.niit.ekart.models.Cart;
import com.niit.ekart.models.CartItem;
import com.niit.ekart.models.User;


public interface CartDAO {
	public void addCartItem(CartItem cartItem);
	public void deleteCartItem(int cartId,int productId);
	public void deleteCart(int product,int cartId);
	public Cart getCart(User user);
	public void updateCart(Cart cart);

	
	
	public List<CartItem> viewCart(Cart cart);
	public List<CartItem> getCart(int productId,int cartId);
	
}
