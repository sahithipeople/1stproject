package com.assessment.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class Service {
	   @Autowired
	   private  Repository rp;
	   
	public List<Employee> display() {
		
		return rp.findAll();
	}
	public void saveEmployee(Employee employee) {
		rp.save(employee);
	}
 public Employee getEmployee(long id) {
	 return rp.findById(id).get();
 }
public void deleteEmployee(long id) {
	rp.deleteById(id);
}
}
