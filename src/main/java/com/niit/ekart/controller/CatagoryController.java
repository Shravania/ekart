package com.niit.ekart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ekart.DAO.CatagoryDAO;
import com.niit.ekart.DAO.ProductDAO;
import com.niit.ekart.models.Catagory;
import com.niit.ekart.models.Product;


@Controller
public class CatagoryController {
	
	@Autowired
	private CatagoryDAO cd;
	@Autowired
	private ProductDAO pd;
	private Product product;
	private Catagory catagory;
	
	
	@RequestMapping("/Catagorys")
	public ModelAndView Catagorys(){
		for(Catagory c:cd.getCatagorys()){
			System.out.println(c.getId());
		}
		return new ModelAndView("viewcatagory").addObject("catagorys",cd.getCatagorys());
	}
	
	@RequestMapping(value="Catagory/edit")
	public ModelAndView editCatagory(){
		return new ModelAndView("addcatagory","command",new Catagory());
	}
	
	
	
	@RequestMapping("Catagory/delete")
	public String deleteCatagory(HttpServletRequest req) {
		int catagoryId=Integer.parseInt(req.getParameter("c"));
        
        cd.deleteCatagory( catagoryId);
        return "redirect:/Catagorys";
	}

	@RequestMapping(value="/Catagory",method=RequestMethod.GET)
	public ModelAndView addCatagory(){
		ModelAndView mv=new ModelAndView("addcatagory","command",new Catagory());
		mv.addObject("Categoryitems", cd.getCatagorys());
		System.out.println("list category");
		System.out.println("category");
		return mv;
	}
	
	@RequestMapping(value="/Catagory",method=RequestMethod.POST)
	public String addCatagory(ModelMap model, @Valid @ModelAttribute("ekart") Catagory c){
		cd.addCatagory(c);
		
        return "redirect:/Catagory";
	}

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategories(Model model) {
		System.out.println("hiiiii");
		List<Catagory> cList = cd.getCatagorys();
		List<Product> productList = pd.getProducts();
		System.out.println("welcomeeeee");
		List<List> categoryList = new ArrayList(new ArrayList<Product>(10));
		String[] categoryNameList = new String[categoryList.size()];
		System.out.println("how are u"+categoryNameList);
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println("whatsuppppppp");
			categoryNameList[i] = cd.getCatagory(cd.getCatagory(i + 1).getId())
					.getName();
			System.out.println("list is::"+categoryNameList);
			List<Product> productsByCategoryId = pd.productByCategory(i + 1);
			System.out.println("productss displayed");
			categoryList.add(productsByCategoryId);
			System.out.println("categoryNameList " + categoryNameList[i]);

		}
		model.addAttribute("product", product);
		model.addAttribute("catagory", catagory);
		model.addAttribute("ProductList", productList);
		model.addAttribute("CategoryList", cList);
		model.addAttribute("isCategoryClicked", "true");
		model.addAttribute("isProductClicked", "true");
		model.addAttribute("product",pd);
		
		return "/";
	}*/
	
}