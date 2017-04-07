package com.niit.ekart.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekart.models.Cart;
import com.niit.ekart.models.CartItem;
import com.niit.ekart.models.User;

@Repository
@Service("cartService")
public class CartDAOImpl implements CartDAO{
	

	@Autowired
	private SessionFactory factory;
	

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addCartItem(CartItem cartItem) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		session.saveOrUpdate(cartItem);
		System.out.println(cartItem.getTotalPrice()+" added");
		tx.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateCart(Cart cart) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		session.saveOrUpdate(cart);
		tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteCart(int prodcutId,int cartId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Criteria cr=session.createCriteria(CartItem.class);
		cr.add(Restrictions.eq("cartGroupId.productId.id",prodcutId));
		List<CartItem> items = cr.list();
		Cart cart = (Cart)session.get(Cart.class, new Integer(cartId));
		System.out.println("heloooooo");
		for(CartItem item:items){
			System.out.println("hiiiii");
		cart.getCartItems().remove(item);
		}
		session.saveOrUpdate(cart);
		tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteCartItem(int cartId,int id) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Criteria cr=session.createCriteria(CartItem.class);
		cr.add(Restrictions.eq("cartGroupId.cartId.cartId",cartId));
		cr.add(Restrictions.eq("cartGroupId.productId.productId",id));
		CartItem item = (CartItem)cr.list().get(0);
		Cart cart = (Cart)session.get(Cart.class, new Integer(cartId));
		cart.getCartItems().remove(item);
		session.saveOrUpdate(cart);
		tx.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Cart getCart(User user) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Criteria cr=session.createCriteria(Cart.class);
		
		cr.add(Restrictions.eq("userId",user));
		//System.out.println("hii"+user.getId());
		Cart cart=(Cart)cr.uniqueResult();
		
		tx.commit();
		
		return cart;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<CartItem> viewCart(Cart cart) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Criteria cr=session.createCriteria(CartItem.class)/*.add(Restrictions.eq("cartGroupId.cartId", cart))*/;
		List<CartItem> cartItems=(List<CartItem>)cr.list();
		tx.commit();
		return cartItems;
	}
	
	public List<CartItem> getCart(int productId,int cartId){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		System.out.println("==START==");
		Criteria cr=session.createCriteria(CartItem.class).add(Restrictions.eq("cartGroupId.productId.productId",productId));
		cr.add(Restrictions.eq("cartGroupId.cartId.cartId",cartId));
		List<CartItem> cartItems=cr.list();
		System.out.println("==START==");
		for(CartItem c:cartItems){
			System.out.println(c.getTotalPrice());
		}
		System.out.println("==END==");
		System.out.println("==END==");
		tx.commit();
		return cartItems;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<CartItem> viewCart(User user) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		Criteria cr=session.createCriteria(CartItem.class).add(Restrictions.eq("cartGroupId.cartId", getCart(user)));
		List<CartItem> cartItems=(List<CartItem>)cr.list();
		tx.commit();
		return cartItems;
}
}
