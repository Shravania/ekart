package com.niit.ekart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	 	private int id;
	    private String name;
	    private String description;
	    private String price;
	    private String catagoryName;
	    /*@ManyToOne
	    private Catagory catagory;*/

	    public Product(int id) {
	        this.id = id;
	    }

	    public Product(String name, String description, String price, String catagoryName) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.catagoryName = catagoryName;
	    }
	    

	    public Product(int id, String name, String description, String price, String catagoryName) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.catagoryName = catagoryName;
	    }

	    public Product() {
	    }

	    

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getPrice() {
	        return price;
	    }

	    public void setPrice(String price) {
	        this.price = price;
	    }

	    public String getCatagoryName() {
	        return catagoryName;
	    }

	    public void setCatagoryName(String catagoryName) {
	        this.catagoryName = catagoryName;
	    }
	    

}
