package com.msbeigi.pma.dao;

import com.msbeigi.pma.dto.EmployeeProject;
import com.msbeigi.pma.entities.Employee;
import com.msbeigi.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Override
    public List<Employee> findAllById(Iterable<Long> longs);

    @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, count(pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "group by e.first_name, e.last_name ORDER BY 3 DESC;")
    public List<EmployeeProject> employeeProjects();
}


