package com.intern.emp_sys.controller;

import com.intern.emp_sys.error.EmployeeNotFoundException;
import com.intern.emp_sys.model.Employee;
import com.intern.emp_sys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*POST/employees - Creates a new employee*/
    @PostMapping("/employees")
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createNewEmployee(employee);
    }

    /*GET /employees - Returns a list of all employees*/
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /*GET /employees/{id} - Returns a specific employee by id*/
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    /*PUT /employees/{id} - Updates an existing employee by id*/
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") Integer id, @RequestBody Employee employee) throws EmployeeNotFoundException{
        return employeeService.updateEmployeeById(id, employee);
    }

    /*DELETE /employees/{id} - Deletes an employee by id*/
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id) throws EmployeeNotFoundException{
         employeeService.deleteEmployeeById(id);
         return "Employee with id: " + id + " deleted successfully";
    }

}
