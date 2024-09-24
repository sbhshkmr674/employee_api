package com.ss.employee.api.service;

import com.ss.employee.api.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    public Employee createEmployee(Employee employee);
    public Employee getEmployeeDetails(Integer id);
    public List<Employee> getAllEmployees();
}
