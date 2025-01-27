package com.sathya.MVCemployee.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
@Id
	private int id;
	private String name;
	private String gender;
	private String doj;
	private long phoneno;
	private int deptno;
	private double department;
	private String email;
    private double salary;
    private double da;
    private double hra;
    private double totalsalary;
}

