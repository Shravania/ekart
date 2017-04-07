package com.niit.ekart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ekart.models.User;


@Controller
public class HomeController {
	
	/*@RequestMapping("/")
    public String Welcome(){
    	return"Welcome";
	}*/
	 @RequestMapping("/")
	    public ModelAndView Welcome(){
	    	return new ModelAndView("Welcome","command",new User());
	    }
	 @RequestMapping(value="/aboutUs")
		public ModelAndView aboutUs(){
			return new ModelAndView("aboutUs");
	 }
    @RequestMapping("/Login")
    public ModelAndView Login(){
    	return new ModelAndView("Login","command",new User());
    }
    @RequestMapping("/Signup")
    public ModelAndView Signup(){
    	return new ModelAndView("Signup","command",new User());
    }
   
}
	
	
	
