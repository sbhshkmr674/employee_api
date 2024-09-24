package com.ss.employee.api.controller;

import com.ss.employee.api.entity.Employee;
import com.ss.employee.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/v1")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees/create")
   public Employee addEmployeeDetails(@RequestBody Employee employee)
   {
       return employeeService.createEmployee(employee);
   }
   @GetMapping("/employees/{id}")
   public Employee getAllEmployeeDetails(@PathVariable Integer id)
   {
       return  employeeService.getEmployeeDetails(id);
   }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return  employeeService.getAllEmployees();
    }
}
