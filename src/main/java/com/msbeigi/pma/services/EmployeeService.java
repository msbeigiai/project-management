package com.msbeigi.pma.services;

import com.msbeigi.pma.dao.EmployeeRepository;
import com.msbeigi.pma.dto.EmployeeProject;
import com.msbeigi.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<EmployeeProject> employeeProjects() {
        return employeeRepository.employeeProjects();
    }


}
