package com.niit.ekart.DAO;



import com.niit.ekart.models.ShippingAddress;
import com.niit.ekart.models.User;
import com.niit.ekart.models.UserRole;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Service("customerService")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory factory;
	
	private User user;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	
	public int addUser(User user) {
		System.out.println(isNewUser(user));
		if(!isNewUser(user)){
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
		tx.begin();	
		session.saveOrUpdate(user);
		UserRole r=new UserRole(user.getId(),"User");
		tx.commit();
		return 1;
		}
		return 0;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteUser(int userId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("id",userId));
		User user=(User)cr.uniqueResult();
		tx.begin();
		session.delete(user);
		tx.commit();
	}
	   
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> getUsers() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		List<User> users=cr.list();
		tx.commit();
		return users;
	}

       @Transactional(propagation=Propagation.SUPPORTS)
		public boolean isNewUser(User user) {
			boolean newUser=false;
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eq("mailId",user.getMailId()));
			List<User> users=cr.list();
			System.out.println("Size "+users.size());
			if(users.size()>0)
			{
				newUser=true;
			}
			tx.commit();
			return newUser;
		}
	    
	    @Transactional(propagation=Propagation.SUPPORTS)
		public User verifyUser(User c) {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eq("mailId",c.getMailId()));
			cr.add(Restrictions.eq("password",c.getPassword()));
			user=(User)cr.uniqueResult();
			tx.commit();
			return user;
		}
	    
	    public User getUser() {
	        return user;
	    }

	    
	    

	    @Transactional(propagation=Propagation.SUPPORTS)
		public User getUser(int userId) {
			Session session=factory.getCurrentSession();
			Criteria ct=session.createCriteria(User.class);
			ct.add(Restrictions.eq("id",userId));
			User c=(User)ct.uniqueResult();
			return c;
		}

		@Transactional(propagation=Propagation.SUPPORTS)
		public void updateUser(User user) {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(user);
			tx.commit();
		}
		@Transactional(propagation=Propagation.SUPPORTS)
		public void updateRole(int roleId) {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eq("id",roleId));
			Criteria rcr=session.createCriteria(UserRole.class);
			rcr.add(Restrictions.eq("roleId",(User)cr.uniqueResult()));
			UserRole ur=(UserRole)rcr.uniqueResult();
			System.out.println(ur.getRoleId().getId());
			ur.setRoleName("ROLE_SELLER");
			session.update(ur);
			tx.commit();
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public String getRoleName() {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(UserRole.class);
			cr.add(Restrictions.eq("roleId",getUser()));
			UserRole ur=(UserRole)cr.uniqueResult();
			tx.commit();
			return ur.getRoleName();
		}

		@Transactional(propagation=Propagation.SUPPORTS)
		public List<ShippingAddress> viewShippingAddress() {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(ShippingAddress.class);
			cr.add(Restrictions.eq("userId",user));
			List<ShippingAddress> shippingAddress=cr.list();
			tx.commit();
			return shippingAddress;
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public ShippingAddress getShippingAddress() {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(ShippingAddress.class);
			cr.add(Restrictions.eq("userId",user));
			cr.setFirstResult(1);
			ShippingAddress shippingAddress=(ShippingAddress)cr.uniqueResult();
			tx.commit();
			return shippingAddress;
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public ShippingAddress getShippingAddress(User u) {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			Criteria cr=session.createCriteria(ShippingAddress.class);
			cr.add(Restrictions.eq("userId",u));
			cr.setFirstResult(1);
			ShippingAddress shippingAddress=(ShippingAddress)cr.uniqueResult();
			tx.commit();
			return shippingAddress;
		}
		
		@Transactional(propagation=Propagation.SUPPORTS)
		public void addShippingAddress(ShippingAddress s) {
			Session session=factory.getCurrentSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(s);
			tx.commit();
		}

	   
}
