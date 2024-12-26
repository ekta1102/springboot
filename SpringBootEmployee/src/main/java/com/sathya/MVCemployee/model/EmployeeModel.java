package com.sathya.MVCemployee.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
	@Id
private int id;
private String name;
private long phoneno;
private String gender;
private int deptno;
private double department;
private String doj;
private double salary;
private String email;

}
