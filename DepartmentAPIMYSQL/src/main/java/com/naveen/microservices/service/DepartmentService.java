package com.naveen.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.naveen.microservices.entity.Department;
import com.naveen.microservices.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	@Autowired
	public DepartmentRepository repo;

	public Department addDepartment(Department dept) {
		// TODO Auto-generated method stub
		log.info("Adding department in service");
		return repo.save(dept);
		
	}
	public Optional<Department> findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("DepartmentAPI Response:"+repo.findById(departmentId));
		return repo.findById(departmentId);
	}
	
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return repo.findAll();
		
	}

}
