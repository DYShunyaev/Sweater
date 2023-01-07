package com.DYShunyaev.Project.service;

import com.DYShunyaev.Project.models.Employee;
import com.DYShunyaev.Project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> showAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public boolean existById(long id) {
        employeeRepository.existsById(id);
        return true;
    }

    public Optional<Employee> showById(long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
