package com.employee.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.management.exceptions.EmployeeNotFoundException;
import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
    	Employee employee = employeeRepository.findById(id).orElse(null);
    	if(employee==null) {
    		throw new EmployeeNotFoundException("Employee doesn't exists with id : "+id);
    	}
        employee.setName(employeeDetails.getName());
        employee.setDesignation(employeeDetails.getDesignation());
        employee.setSalary(employeeDetails.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if(employee == null) {
			throw new EmployeeNotFoundException("Employee doesn't exists with id : "+id);
		}
        employeeRepository.delete(employee);
        return true;
    }

	@Override
	public Employee getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee doesn't exists with id : "+id);
		}
		return employee;
	}

}
