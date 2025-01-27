 package com.sathya.springbootmvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.Service.productService;
import com.sathya.springbootmvc.productEntity.ProductEntity;
import com.sathya.springbootmvc.productmodel.ProductModel;

import jakarta.validation.Valid;



@org.springframework.stereotype.Controller
public class Controller {
	
	
	@Autowired
	productService service;
	
	@GetMapping("/text")
       public String say()
       {
    	   return "greeting";
       }
	   
	   
	   
	   
	   @GetMapping("/productform")
	   public String getproductform(Model model)
	   {
		   ProductModel productModel = new ProductModel();
		  productModel.setMadein("INDIA");
		  productModel.setQuantity(2);
		  productModel.setDiscountrate(10.5);
		   model.addAttribute("productModel", productModel);
		   return "addproduct";
	   }
	   
	   
	   @PostMapping("/submit")
	   public String submitproduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	   {
	   	  HashMap<String, String> validationErrors = new HashMap<String,String>();
	   	  if(bindingResult.hasErrors())
	   	  {
	   		  for(FieldError fieldError : bindingResult.getFieldErrors())
	   		  {
	   			  validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	   		  }
	   		  
	   		  model.addAttribute("validationErrors", validationErrors);
	   		  return "addproduct";
	   	  }
       
		   service.saveProductDetails(productModel);
	   	   return "redirect:/getallproducts";
	   } 

	   
	   @GetMapping("/getallproducts")
	   public String getallproduct(Model model)
	   {
		 List<ProductEntity> product = service.getallproducts();
		  
		  model.addAttribute("product", product);
		  return "product-list";
	   }
	   
	   
	   
	   @GetMapping("/getsearchform")
	   public String getsearchform() 
	   {
	       return "Search";
	   }
     

        @PostMapping("/searchbyid")
        public String searchbyid(@RequestParam long id, Model model)
      {
	      ProductEntity product= service.searchById(id);
	      
	       model.addAttribute("product", product);
	        return "Search";
       }
        
        
        
        @GetMapping("/delete/{id}")
        public String deleteProductId(@PathVariable Long id)
        {
        
		service.deletebyid(id);
        return "redirect:/getallproducts";
        }
        
        
        @GetMapping("/edit/{id}")
        public String editbyid(@PathVariable long id, Model model)
        {
        	ProductModel productModel = service.editbyid(id);
        	
        	model.addAttribute("Product", productModel);
        	model.addAttribute("id", id);
        	return "Edit-form";
        }
        
        
       @PostMapping("/editproductsave/{id}")
       public String updateproduct(@PathVariable long id,ProductModel productModel)
       {
    	   service.updatebyid(id, productModel);
    	   return "redirect:/getallproducts";
    	   
       }
    
       
       
  }
        
  




	   
	   
	   