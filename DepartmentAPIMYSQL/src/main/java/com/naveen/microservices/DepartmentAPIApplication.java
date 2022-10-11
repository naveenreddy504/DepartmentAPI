package com.naveen.microservices;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.naveen.microservices.entity.Department;
import com.naveen.microservices.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentAPIApplication {
	@Autowired 
	private DepartmentRepository departmentRepo;
	
	
	@PostConstruct
	public void init() {
		List<Department> departments=Arrays.asList(new Department(Long.valueOf(101),"IT","Khammam","IT-98"),new Department(Long.valueOf(102),"IT2","Khammam","IT-98"));		
		departmentRepo.saveAll(departments);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentAPIApplication.class, args);
	}

}
