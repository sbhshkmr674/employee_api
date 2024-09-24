package com.ss.employee.api.service;

import com.ss.employee.api.entity.Employee;
import com.ss.employee.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeDetails(Integer id) {
      Employee employee = employeeRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Error fecting Employee Id : "+id);
        });
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
