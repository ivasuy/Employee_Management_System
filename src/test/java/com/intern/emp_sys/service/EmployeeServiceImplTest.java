package com.intern.emp_sys.service;

import com.intern.emp_sys.model.Employee;
import com.intern.emp_sys.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    AutoCloseable autoCloseable;
    Employee employee;

    @BeforeEach
    void setUp() {
        autoCloseable = org.mockito.MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee(1, "Vasu", "vasu7yadav@gmail.com", "1234567890", "Delhi");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateNewEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assert (employeeService.createNewEmployee(employee) == employee);
    }

    @Test
    void testGetAllEmployees() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(java.util.List.of(employee));
    }

    @Test
    void testGetEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(employee));
    }

    @Test
    void testUpdateEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(employee));
        when(employeeRepository.save(employee)).thenReturn(employee);
    }

    @Test
    void testDeleteEmployeeById() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        employeeRepository.deleteById(1);
    }
}