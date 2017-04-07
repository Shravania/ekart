package com.niit.ekart.DAO;


import com.niit.ekart.models.Catagory;

import com.niit.ekart.DAO.CatagoryDAO;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service("categoryService")
public class CatagoryDAOImpl implements CatagoryDAO{
	@Autowired
	private SessionFactory factory;
	private Catagory catagory;
	
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean addCatagory(Catagory catagory) {
		/*Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		tx.begin();
		
		session.save(catagory);
		tx.commit();*/
		try
		{
			if(getCatagory(catagory.getId())!=null)
             {
 	             return false;
             }
			factory.getCurrentSession().save(catagory);
			return true;
		}
		catch(HibernateException e)
		{
		 	e.printStackTrace();
			return false;
		}
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Catagory> getCatagorys() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Catagory.class);
		List<Catagory> catagories=cr.list();
		tx.commit();
		System.out.println(catagories);
		return catagories;
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Catagory viewCatagory(int catagoryId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Catagory.class);
		cr.add(Restrictions.eq("id",catagoryId));
		return (Catagory)cr.uniqueResult();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteCatagory(int catagoryId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Catagory.class);
		cr.add(Restrictions.eq("id",catagoryId));
		Catagory catagory=(Catagory)cr.uniqueResult();
		tx.begin();
		session.delete(catagory);
		tx.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Catagory getCatagory (int catagoryId) {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(Catagory.class);
		cr.add(Restrictions.eq("id",catagoryId));
		Catagory catagory=(Catagory)cr.uniqueResult();
		tx.commit();
		return catagory;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public Catagory getCatagory(){
		return catagory;
	}

	
}
