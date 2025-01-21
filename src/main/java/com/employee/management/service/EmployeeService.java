package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee employeeDetails);
    boolean deleteEmployee(Long id);
	Employee getEmployeeById(Long id);
}
