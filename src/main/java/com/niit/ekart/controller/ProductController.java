package com.niit.ekart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ekart.DAO.ProductDAO;
import com.niit.ekart.DAO.UtilityDAO;
import com.niit.ekart.models.Catagory;
import com.niit.ekart.models.Product; 

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO pd;
	
	@Autowired
	private UtilityDAO ud;
	
	@RequestMapping("/viewProduct")
	public ModelAndView Product(){
		for(Product p:pd.getProducts()){
			System.out.println(p.getId());
		}
		return new ModelAndView("viewproduct").addObject("products",ud.getJson(pd.getProducts()));
	}
	
	@RequestMapping("/Products")
	public ModelAndView Products(){
		
		return new ModelAndView("products").addObject("products",ud.getJson(pd.getProducts()));
	}
	
	@RequestMapping(value="Product/edit")
	public ModelAndView editProduct(){
		return new ModelAndView("addproduct","command",new Product());
	}
	
	@RequestMapping("Product/delete")
	public String deleteProduct(HttpServletRequest req) {
		int productId=Integer.parseInt(req.getParameter("p"));
        
        pd.deleteProduct( productId);
        return "redirect:/Products";
        }
	
	@RequestMapping(value="/Product",method=RequestMethod.GET)
	public ModelAndView addProduct(){
		ModelAndView mv=new ModelAndView("addproduct","command",new Product());
		mv.addObject("Productitems", pd.getProducts());
		
		return mv;
	}
	@RequestMapping(value="/Product",method=RequestMethod.POST)
	public String addProduct(ModelMap model, @Valid @ModelAttribute("ekart") Product p){
		pd.addProduct(p);
		
        return "redirect:/Product";
	}
	
	}
	
	
