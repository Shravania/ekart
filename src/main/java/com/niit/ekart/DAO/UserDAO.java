package com.niit.ekart.DAO;

 import java.util.List;

import com.niit.ekart.models.ShippingAddress;
import com.niit.ekart.models.User;


public interface UserDAO {
	public int addUser(User user);
	public User verifyUser(User user);
	public User getUser();
	public User getUser(int UserId);
	public void updateUser( User  user);
	public void deleteUser(int userId);
	public List< User> getUsers();
	public void addShippingAddress(ShippingAddress s);
	public ShippingAddress getShippingAddress();
	public ShippingAddress getShippingAddress(User user);
	public List<ShippingAddress> viewShippingAddress();
	public void updateRole(int roleId);
	public String getRoleName();
	
	
	
	
}

