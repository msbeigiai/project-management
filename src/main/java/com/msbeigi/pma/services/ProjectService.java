package com.msbeigi.pma.services;

import com.msbeigi.pma.dao.ProjectRepository;
import com.msbeigi.pma.dto.ChartData;
import com.msbeigi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
