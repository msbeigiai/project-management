package com.msbeigi.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msbeigi.pma.dao.EmployeeRepository;
import com.msbeigi.pma.dao.ProjectRepository;
import com.msbeigi.pma.dto.ChartData;
import com.msbeigi.pma.dto.EmployeeProject;
import com.msbeigi.pma.entities.Employee;
import com.msbeigi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class HomeController {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projectList", projects);

        List<ChartData> projectData = projectRepository.getProjectStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCount", jsonString);

        List<EmployeeProject> employeesProjectsCount = employeeRepository.employeeProjects();
        model.addAttribute("employeeListProjectsCount", employeesProjectsCount);

        return "main/home";
    }
}
