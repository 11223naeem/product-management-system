package com.naeem.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naeem.demo.Product.Product;
import com.naeem.demo.pssword.LoginPass;
import com.naeem.demo.repo.ProductRepo;
import com.naeem.demo.repo.loginPassRepo;

@Controller

public class productController {
	
	@Autowired
	loginPassRepo loginRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/createAccount")
	public String createAccount() {
		return "createAccount";
	}
	
	@RequestMapping("/Features")
	public String features() {
		return"Features";
	}
	
	@RequestMapping("/CreateAccounts")
	public String CreateAccounts(@RequestParam() String name ,@RequestParam() String pass ) {
		
		LoginPass user = new LoginPass( pass, name);
		loginRepo.save(user);
		
		
	
		return "success";
	}
	
	@RequestMapping("/loginAccount")
	public String loginAccoun(@RequestParam() String name ,@RequestParam() String pass) {
		LoginPass user = loginRepo.findByName(name);

	    // ✅ check user exists
	    if (user != null && user.getPassword().equals(pass)) {
	        return "Features";  // go to dashboard
	    }
		return "erorr";
	}
	@RequestMapping("/addProduct")
	public String addProduct(@RequestParam() String name ,@RequestParam() String place ,@RequestParam() String type ,@RequestParam() int warrenty,Model m) {
		Product p = new Product(name,  place, type, warrenty);
		productRepo.save(p);
		m.addAttribute("title","Product Status");
		m.addAttribute("msg","Product Added Successfully");
		return "added";
	}
	
	@RequestMapping("/getProducts")
	public String getproduct(Model m) {
		
		
		m.addAttribute("title","All Product");
		m.addAttribute("msg",productRepo.findAll());
		return"featch";
	}
	
	@RequestMapping("/searchByName")
	public String searchbyname(@RequestParam() String name, Model m) {
	
		List<Product> prod=productRepo.findByName(name);
		if(prod.isEmpty()) {
			m.addAttribute("error", "Not found By This name : "+name);
		}
		m.addAttribute("title", "Serch By Name");
		m.addAttribute("msg", prod);
		return"featch";
		
	}
	
	@RequestMapping("/searchByWarranty")
	public String searchByWarranty(@RequestParam() int warrenty, Model m) {
	
		List<Product> prod=productRepo.findByWarrenty(warrenty);
		if(prod.isEmpty()) {
			m.addAttribute("error", "Not found By This year : "+warrenty);
		}
		m.addAttribute("title", "Serch By year");
		m.addAttribute("msg", prod);
		return"featch";
		
	}
	
	@RequestMapping("/searchByType")
	public String searchByWarranty(@RequestParam() String Type, Model m) {
	
		
		List<Product> prod=productRepo.findByTypeContainingIgnoreCase(Type);
		
		if(prod.isEmpty()) {
			m.addAttribute("error", "Not found By This Type : "+Type);
		}
		else {
			
			m.addAttribute("title", "Serch By Type");
			m.addAttribute("msg", prod);
		}
		
		return"featch";
		
	}
	
	
	
	
}





