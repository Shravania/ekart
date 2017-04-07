package com.niit.ekart.DAO;

import com.niit.ekart.models.Catagory;
import java.util.List;

public  interface CatagoryDAO  {

	 
	public boolean addCatagory(Catagory catagory);
	public List<Catagory> getCatagorys();
	public Catagory viewCatagory(int catagoryId);
	public void deleteCatagory(int catagoryId);
	public Catagory getCatagory();
	public Catagory getCatagory(int catagoryId);
	
}