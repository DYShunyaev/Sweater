package com.DYShunyaev.Project.repository;

import com.DYShunyaev.Project.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
