package com.sathya.MVCemployee.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.MVCemployee.Entity.EmployeeEntity;
import com.sathya.MVCemployee.model.EmployeeModel;
import com.sathya.MVCemployee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	
	public EmployeeEntity saveEmployeeData(EmployeeModel employeeModel) {
		
		double da;
		da = 5.0 /100 * employeeModel.getSalary();
		
		double hra;
		hra = 10.0 /100 * employeeModel.getSalary();
		
		double totalsalary;
		totalsalary = da + hra + employeeModel.getSalary();
		
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setId(employeeModel.getId());
		entity.setName(employeeModel.getName());
		entity.setGender(employeeModel.getGender());
		entity.setDoj(employeeModel.getDoj());
		entity.setPhoneno(employeeModel.getPhoneno());
		entity.setDeptno(employeeModel.getDeptno());
		entity.setDepartment(employeeModel.getDepartment());
		entity.setEmail(employeeModel.getEmail());
		entity.setSalary(employeeModel.getSalary());
		entity.setDa(da);
		entity.setHra(hra);
		entity.setTotalsalary(totalsalary);  
		
	   
		return  repository.save(entity);
	
   }


	 public List<EmployeeEntity> getEmployeeDetails()
	 {
		 List<EmployeeEntity> entity = repository.findAll();
		 return entity;
	 }
}