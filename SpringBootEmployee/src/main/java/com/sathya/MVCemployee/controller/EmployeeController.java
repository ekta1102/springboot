package com.sathya.MVCemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.MVCemployee.Entity.EmployeeEntity;
import com.sathya.MVCemployee.model.EmployeeModel;
import com.sathya.MVCemployee.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeservice;
	
	
	   @GetMapping("/employeeform")
       public String getEmployee()
       {
    	   return "employee";
       }
	   
	   
	   @PostMapping("/submit")
	   public String sendEmployee(EmployeeModel employeeModel)
	   {
		   employeeservice.saveEmployeeData(employeeModel);
		   return "complete";
	   }
	  
	   @GetMapping("/getallemployeedetails")
	   public String getemployeedetails(Model model) 
	   {
	     	List<EmployeeEntity> employee= employeeservice.getEmployeeDetails();
	   	
	     	model.addAttribute("Employee",employee);
	   	    return "employee details";
	   }
	   
}
