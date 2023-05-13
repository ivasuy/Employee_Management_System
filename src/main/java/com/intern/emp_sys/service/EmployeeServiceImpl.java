package com.intern.emp_sys.service;

import com.intern.emp_sys.model.Employee;
import com.intern.emp_sys.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployeeById(Integer id, Employee employee) {

        Employee employeeToUpdate = employeeRepository.findById(id).get();

        if(Objects.nonNull(employee.getEmployeeName()) && !" ".equalsIgnoreCase(employee.getEmployeeName())) {
            employeeToUpdate.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmployeeEmail()) && !" ".equalsIgnoreCase(employee.getEmployeeEmail())) {
            employeeToUpdate.setEmployeeEmail(employee.getEmployeeEmail());
        }
        if(Objects.nonNull(employee.getEmployeePhone()) && !" ".equalsIgnoreCase(employee.getEmployeePhone())) {
            employeeToUpdate.setEmployeePhone(employee.getEmployeePhone());
        }
        if(Objects.nonNull(employee.getEmployeeAddress()) && !" ".equalsIgnoreCase(employee.getEmployeeAddress())) {
            employeeToUpdate.setEmployeeAddress(employee.getEmployeeAddress());
        }

        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }


}
