package com.intern.emp_sys.service;

import com.intern.emp_sys.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee updateEmployeeById(Integer id, Employee employee);

    void deleteEmployeeById(Integer id);
}
