package com.niit.ekart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ekart.DAO.CartDAO;
import com.niit.ekart.DAO.ProductDAO;
import com.niit.ekart.DAO.UserDAO;
import com.niit.ekart.models.CartGroup;
import com.niit.ekart.models.CartItem;
import com.niit.ekart.models.Cart;

@Controller
public class CartController {

	@Autowired
	private ProductDAO pd;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private UserDAO userDAO;
	
  
	@RequestMapping(value="/Cart")
	public ModelAndView Cart(){
		System.out.println("hi..");
		com.niit.ekart.models.Cart cart=cartDAO.getCart(userDAO.getUser());
		System.out.println();
		System.out.println("hello"+userDAO.getUser());
		
	return new ModelAndView("viewcart","cartItems",cartDAO.viewCart(cart));
	}
	
	@RequestMapping(value={"/addToCart/{id}"})
	public String addToCart(HttpServletRequest request,@PathVariable(value="id") Integer id){
		String redirect="redirect:/";
		
		/*try{
			userDAO.getUser().getFirstName();
		}catch(Exception e){
			redirect="redirect:/login";
			return redirect;
		}*/
		Cart cart=new Cart();
		System.out.println("hi");
		try{
			System.out.println("hello");
			cart.setCartId( cartDAO.getCart(userDAO.getUser()).getCartId());
		}catch(Exception e){}
			cart.setUserId(userDAO.getUser());
		
		CartGroup cartGroup=new CartGroup();
		cartGroup.setProductId(pd.getProduct(id));
		cartGroup.setCartId(cart);
		System.out.println("hi");
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(pd.getProduct(id).getPrice());
		cartItem.setCartGroupId(cartGroup);
		System.out.println("hello");
		 cartDAO.addCartItem(cartItem);
		
		cart.getCartItems().addAll( cartDAO.getCart(userDAO.getUser()).getCartItems());
		//cart.getCartItems().add(cartItem);
	 cartDAO.updateCart(cart);
		return redirect="redirect:/Cart/";
	}


	@RequestMapping(value="/delete/{cart}/{product}")
	public String deleteCartItem(@PathVariable(value="cart") Integer cartId,@PathVariable(value="product") Integer id){
		cartDAO.deleteCartItem(cartId, id);
		return "redirect:/Cart/";
	}	
	
}







