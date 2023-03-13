package com.msbeigi.pma.controllers;

import com.msbeigi.pma.dao.EmployeeRepository;
import com.msbeigi.pma.dao.ProjectRepository;
import com.msbeigi.pma.entities.Employee;
import com.msbeigi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("project", new Project());
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, /*@RequestParam List<Long> employees,*/ Model model) {
        // this should handle saving to the database
        projectRepository.save(project);
        /*List<Employee> chosenEmployees = employeeRepository.findAllById(employees);
        for (Employee employee : chosenEmployees) {
            employee.setProjects(projects);
            employeeRepository.save(employee);
        }*/
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects";
    }

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projectList = projectRepository.findAll();
        model.addAttribute("projects", projectList);
        return "projects/list-projects";
    }
}
