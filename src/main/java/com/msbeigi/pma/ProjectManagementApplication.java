package com.msbeigi.pma;

import com.msbeigi.pma.dao.EmployeeRepository;
import com.msbeigi.pma.dao.ProjectRepository;
import com.msbeigi.pma.entities.Employee;
import com.msbeigi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProjectManagementApplication {

	/*@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository projRepo;*/
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
