package com.naveen.microservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.naveen.microservices.entity.Department;
import com.naveen.microservices.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	@Autowired
	DepartmentService service;
	@PostMapping("/")
	public Department addDepartment(@RequestBody Department dept) {
		log.info("Adding department in DepartmentController");
		return service.addDepartment(dept);
	}
	
	public RestTemplate getResttemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/{departmentId}")
	public Optional<Department> findDepartmentById(@PathVariable("departmentId") Long departmentId) {
		log.info("DepartmentAPI Request: findDepartmentById :" +departmentId);		
		return service.findDepartmentById(departmentId);
	}
	
	@GetMapping("/data")
	public List<Department> getDepartments(){
		return service.getDepartments();
	}	
}
