package com.niit.ekart.DAO;

import com.niit.ekart.models.Catagory;
import com.niit.ekart.models.Product;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service("productService")
public class ProductDAOImpl implements ProductDAO{
	 
	@Autowired
	private SessionFactory factory;
	private Product product;
	private CatagoryDAO cd;

	//CRUD operations for Product
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addProduct(Product product) {
		Session session=factory.getCurrentSession();
	    Transaction tx=session.beginTransaction();
	    tx.begin();
	    session.saveOrUpdate(product);
	    tx.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Product getProduct(int productId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		cr.add(Restrictions.eq("id",productId));
		Product product=(Product)cr.uniqueResult();
		tx.commit();
		return product;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Product> getProducts() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		List<Product> products=cr.list();
		tx.commit();
		return products;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteProduct(int productId) {
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		cr.add(Restrictions.eq("id",productId));
		Product product=(Product)cr.uniqueResult();
		tx.begin();
		session.delete(product);
		tx.commit();
	}

/*	@Transactional
	public boolean delete(int id) {
		System.out.println("delete method");
		try
		{
			Session session = factory.openSession();
			Criteria cr =session.createCriteria(Product.class);
			cr.add(Restrictions.eq("id",id));
			Product product=(Product)cr.uniqueResult();
			session.delete(product);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}*/
	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateProduct(Product product){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(product);
		tx.commit();
	}
 
	@Transactional(propagation=Propagation.SUPPORTS)
	public Product getProduct(){
		return product;
	}
	@Transactional
	public List<Product> productByCategory(int id)
	{
		List<Product> productByCategory=new ArrayList<Product>();
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Product.class);
		cr.add(Restrictions.eq("catagory", cd.getCatagory(id)));
		productByCategory=cr.list();
		return productByCategory;
				}
	}

