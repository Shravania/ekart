package com.niit.ekart.DAO;

import java.util.List;

import com.niit.ekart.models.Product;




public interface ProductDAO {
	public void addProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> getProducts();
	public void deleteProduct(int productId);
	public void updateProduct(Product product);
	public Product getProduct();
	public List<Product> productByCategory(int id);
	}



