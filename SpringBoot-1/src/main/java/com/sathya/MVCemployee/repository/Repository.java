package com.sathya.MVCemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.MVCemployee.entity.EmployeeEntity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<EmployeeEntity, Integer>
{

}
