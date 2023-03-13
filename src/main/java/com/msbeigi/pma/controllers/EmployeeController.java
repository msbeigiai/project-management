package com.msbeigi.pma.controllers;

import com.msbeigi.pma.dao.EmployeeRepository;
import com.msbeigi.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model) {
        employeeRepository.save(employee);
        return "redirect:/employees/new";
    }
    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees", employeeList);
        return "employees/list-employees";
    }

}
