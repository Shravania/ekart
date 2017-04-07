package com.niit.ekart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.niit.ekart.DAO.UserDAO;
import com.niit.ekart.models.User;
import com.niit.ekart.models.UserRole;

@Controller
public class UserController {
	@Autowired
	private UserDAO cm;
	
	private UserRole r;
	
	@RequestMapping("/Users")
	public ModelAndView Users(){
		for(User q:cm.getUsers()){
			System.out.println(q.getId());
		}
		return new ModelAndView("viewuser").addObject("users",cm.getUsers());
	}
	@RequestMapping("/edituser")
	public String editCustomer(Model model,HttpServletRequest req) {
		int userId=Integer.parseInt(req.getParameter("q"));

		User user = cm.getUser(userId);
        model.addAttribute("user", user);
        return "cus";
	
	}
	@RequestMapping("/deleteuser")
	public String deletecustomer(HttpServletRequest req) {
		int userId=Integer.parseInt(req.getParameter("q"));
        
        cm.deleteUser(userId);
        return "viewuser";
	}
	@RequestMapping("/User")
	public String Login(ModelMap model,@Valid @ModelAttribute("ekart") User u) {
		
		System.out.println("======"+cm.verifyUser(u));
		System.out.println(cm.getRoleName());
		if(cm.getRoleName(). equals ("admin")){
			
		return("Admin");
		}
		
		else{
			return "redirect:/Products/";
		}
	}
	@RequestMapping("/addUser")
	public String signUp(ModelMap model,@Valid @ModelAttribute("ekart") User u){
		System.out.println(u);
		if(cm.addUser(u)==0){
			return "redirect:/Login";
		}
		return "redirect:/Signup";
		
	}
	}