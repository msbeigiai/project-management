package com.msbeigi.pma.dao;

import com.msbeigi.pma.dto.ChartData;
import com.msbeigi.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as stageStatus FROM project GROUP BY stage;")
    public List<ChartData> getProjectStatus();
}
